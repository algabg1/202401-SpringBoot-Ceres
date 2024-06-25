package com.example.demo.service;

import com.example.demo.Enum.CategoriaEnum;
import com.example.demo.controller.PlantaController;
import com.example.demo.entity.PlantaEntity;
import com.example.demo.entity.dto.PlantaDTO;
import com.example.demo.repository.PlantaRepository;
import com.example.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class PlantaService {
    @Autowired
    private PlantaRepository plantaRepository;

    public boolean criar(PlantaDTO entity) {
        PlantaEntity plantaEntity = new PlantaEntity();
        try {
            if (Utils.findMatchEnum(entity.categoria(), CategoriaEnum.class)) {
                plantaEntity.setCategoria(CategoriaEnum.valueOf(entity.categoria().toUpperCase()));
                plantaEntity.setNome(entity.nome());
                plantaEntity.setOrigem(entity.origem());
                plantaEntity.setCuidados(entity.cuidados());
                plantaEntity.setNome_cientifico(entity.nome_cientifico());
                plantaEntity.setDescricao(entity.descricao());
                plantaEntity.setDataregistro(Date.valueOf(entity.dataregistro()));
                //plantaEntity.setImagem(null);
                plantaRepository.save(plantaEntity);
                return true;
            }
            return false;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
