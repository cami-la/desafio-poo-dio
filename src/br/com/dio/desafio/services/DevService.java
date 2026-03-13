package br.com.dio.desafio.services;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.repositories.BootcampRepository;
import br.com.dio.desafio.repositories.DevRepository;

import java.util.ArrayList;

public class DevService {

    public Dev newDev(Dev dev) throws Exception {

        if(dev != null){

            if(dev.getNome() == null || dev.getNome().trim().isEmpty()){
                throw new Exception("O campo nome é obrigatório");
            }

            return DevRepository.save(dev);

        }else{
            throw new Exception("Dev não pode ser null");
        }
    }


    public Dev findById(int id) throws Exception{

        return DevRepository.findByID(id).orElseThrow(() -> new Exception("Não existe um dev com ID informado"));
    }


    public ArrayList<Dev> findAll(){
        return (ArrayList<Dev>) DevRepository.findAll();
    }


    public boolean deleteById(int id){
        return DevRepository.deleteById(id);
    }


    public void subscribeBootcamp(int devId, int bootcampId) throws Exception {

        Dev dev;
        Bootcamp bootcamp;

        if(devId > 0){
            dev = DevRepository.findByID(devId)
                    .orElseThrow(() -> new Exception("Dev não encontrado com ID informado"));

            if(bootcampId > 0){
                bootcamp = BootcampRepository.findById(bootcampId)
                        .orElseThrow(() -> new Exception("Bootcamp não encontrado com ID informado"));

                if(!bootcamp.getDevsInscritos().contains(dev)){

                    dev.getConteudosInscritos().addAll(bootcamp.getConteudos());
                    bootcamp.getDevsInscritos().add(dev);


                    try{

                        DevRepository.update(dev);
                        BootcampRepository.update(bootcamp);

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                }else{
                    throw new Exception("Esse Dev já se inscreveu nesse Bootcamp");
                }


            }else{
                throw new Exception("bootcampId inválido");
            }

        }else{
            throw new Exception("devId inválido");
        }

    }


    public void progress(int devId) throws Exception{

        Dev dev = findById(devId);
        dev.progredir();
        DevRepository.update(dev);

    }


    public double calculateXP(int devId) throws Exception{
        Dev dev = findById(devId);
        return dev.calcularTotalXp();
    }

}
