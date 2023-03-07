package com.ctacolombia.CTACOLOMBIA.services;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Arl;
import com.ctacolombia.CTACOLOMBIA.dto.entity.Estudiante;
import com.ctacolombia.CTACOLOMBIA.dto.entity.Pais;
import com.ctacolombia.CTACOLOMBIA.dto.entity.TipoDocumento;
import com.ctacolombia.CTACOLOMBIA.dto.repository.ArlRepository;
import com.ctacolombia.CTACOLOMBIA.dto.repository.EstudianteRepository;
import com.ctacolombia.CTACOLOMBIA.dto.repository.PaisRepository;
import com.ctacolombia.CTACOLOMBIA.dto.repository.TipoDocumentoRepository;
import com.ctacolombia.CTACOLOMBIA.dto.response.GeneralResponse;
import com.ctacolombia.CTACOLOMBIA.util.constants.Constants;
import jxl.*;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private ArlRepository arlRepository;

    @Override
    public GeneralResponse findPageEstudiantes(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Estudiante> estudiantePage = estudianteRepository.findAll(pageable);
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, estudiantePage);
    }

    @Override
    public GeneralResponse findEstudianteById(String estudianteDocumento) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(estudianteDocumento);
        if (estudiante.isPresent())
            return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, estudiante.get());
        return GeneralResponse.buildResponseGeneral(HttpStatus.BAD_REQUEST, Constants.NO_DATA_MESSAGE, false, null);
    }

    @Override
    public GeneralResponse insertEstudianteBulk(MultipartFile file) throws IOException, BiffException, ParseException {
        Workbook workbook = Workbook.getWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheet(0);
        //SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        List<Estudiante> estudiantes = new ArrayList<>();

        for (int i = 1; i < sheet.getRows(); i++) {
            Cell[] row = sheet.getRow(i);
            Estudiante estudiante = new Estudiante();

            estudiante.setTipoDocumento(getTipoDocu(Integer.valueOf(row[0].getContents())));
            estudiante.setEstudianteDocumento(row[1].getContents());
            estudiante.setEstudiantePrimernombre(row[2].getContents());
            estudiante.setEstudianteSegundonombre(row[3].getContents());
            estudiante.setEstudiantePrimerapellido(row[4].getContents());
            estudiante.setEstudianteSegundoapellido(row[5].getContents());
            estudiante.setEstudianteGenero(row[6].getContents());
            estudiante.setPais(getPais(Integer.valueOf(row[7].getContents())));

            if (row[8].getType() == CellType.DATE) {
                DateCell dateCell = (DateCell) row[8];
                Date fechaNaci = dateCell.getDate();
                estudiante.setEstudianteNacimiento(fechaNaci);
            }

            estudiante.setEstudianteNiveleducativo(row[9].getContents());
            estudiante.setEstudianteAreatrabajo(row[10].getContents());
            estudiante.setEstudianteCargo(row[11].getContents());
            estudiante.setEstudianteArl(getArl(Long.valueOf(row[12].getContents())));

            estudiantes.add(estudiante);
        }

        estudianteRepository.saveAll(estudiantes);
        return GeneralResponse.buildResponseGeneral(HttpStatus.OK, Constants.SUCCES_MESSAGE, true, estudiantes);
    }

    public TipoDocumento getTipoDocu(Integer tipoDocuId) {
        Optional<TipoDocumento> tipoDocumento = tipoDocumentoRepository.findById(Long.valueOf(tipoDocuId));
        if (tipoDocumento.isPresent()) return tipoDocumento.get();
        return null;
    }

    public Pais getPais(Integer paisId) {
        Optional<Pais> pais = paisRepository.findById(Long.valueOf(paisId));
        if (pais.isPresent()) return pais.get();
        return null;
    }

    public Arl getArl(Long arlId) {
        Optional<Arl> arl = arlRepository.findById(arlId);
        if (arl.isPresent()) return arl.get();
        return null;
    }

}
