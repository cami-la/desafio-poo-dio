package br.com.dio.desafio.services;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.repositories.BootcampRepository;

import java.util.ArrayList;
import java.util.Set;

public class BootcampService {

    public Bootcamp newBootcamp(Bootcamp bootcamp) throws Exception{

        if(bootcamp != null){

            if(bootcamp.getNome() == null || bootcamp.getNome().trim().isEmpty()){
                throw new Exception("O campo nome é obrigatório");
            }

            if(bootcamp.getConteudos().isEmpty()){
                throw new Exception("Um Bootcamp precisa ter pelo menos um conteúdo para ser cadastrado");
            }

            return BootcampRepository.save(bootcamp);

        }else{
            throw new Exception("Bootcamp não pode ser null");
        }

    }

    public Bootcamp findById(int id) throws Exception{

        return BootcampRepository.findByID(id)
                .orElseThrow(() -> new Exception("Não existe um bootcamp com ID informado"));
    }

    public ArrayList<Bootcamp> findAll(){
        return (ArrayList<Bootcamp>) BootcampRepository.findAll();
    }

    public boolean deleteById(int id){
        return BootcampRepository.deleteById(id);
    }

    public Set<Dev> getDevs(int bootcampId) throws Exception{
        Bootcamp bootcamp = findById(bootcampId);
        return bootcamp.getDevsInscritos();
    }

}
