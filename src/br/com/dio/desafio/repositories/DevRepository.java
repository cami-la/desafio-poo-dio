package br.com.dio.desafio.repositories;

import br.com.dio.desafio.dominio.Dev;

import java.util.*;

public class DevRepository {

    private static final Map<Integer, Dev> devs = new HashMap<>();
    private static int id;

    public static Dev save(Dev dev){
        if(dev.getId() == 0){
            dev.setId(++id);
        }
        devs.put(dev.getId(),dev);
        return dev;
    }

    public static Collection<Dev> findAll(){
        return new ArrayList<>(devs.values());
    }

    public static Optional<Dev> findByID(int id){
        return Optional.ofNullable(devs.get(id));
    }

    public static boolean deleteById(int id){
        return devs.remove(id) != null;
    }

    public static void update(Dev dev) throws Exception {

        if(dev.getId() > 0){

           if( devs.containsKey(dev.getId())){
               devs.replace(dev.getId(), dev);
           }else{
               throw new Exception("Dev não encontrado com ID informado");
           }

        }else{
            throw new Exception("ID do Dev inválido");
        }
    }


}
