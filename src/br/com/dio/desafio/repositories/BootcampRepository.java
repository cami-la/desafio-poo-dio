package br.com.dio.desafio.repositories;

import br.com.dio.desafio.dominio.Bootcamp;

import java.util.*;

public class BootcampRepository {

    private static final Map<Integer,Bootcamp> bootcamps = new HashMap<>();
    private static int id;

    public static Bootcamp save(Bootcamp bootcamp){
        if(bootcamp.getId() == 0){
            bootcamp.setId(++id);
        }
        bootcamps.put(bootcamp.getId(), bootcamp);
        return bootcamp;
    }

    public static Collection<Bootcamp> findAll(){
        return new ArrayList<>(bootcamps.values());
    }

    public static Optional<Bootcamp> findById(int id){

        return Optional.ofNullable(bootcamps.get(id));
    }

    public static Optional<Bootcamp> findByID(int id){
        return Optional.ofNullable(bootcamps.get(id));
    }

    public static boolean deleteById(int id){
        return bootcamps.remove(id) != null;
    }

    public static void update(Bootcamp bootcamp) throws Exception {

        if(bootcamp.getId() > 0){

            if( bootcamps.containsKey(bootcamp.getId())){
                bootcamps.replace(bootcamp.getId(), bootcamp);
            }else{
                throw new Exception("Bootcamp não encontrado com ID informado");
            }

        }else{
            throw new Exception("ID do Bootcamp inválido");
        }
    }

}
