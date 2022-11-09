package com.proyecto.turismo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.turismo.models.Destino;

@Service
public class DestinoService {

    List<Destino> destinos = new ArrayList<>();

    public DestinoService() {
        crearLista();
    }

    public void crearLista() {
        Destino destino1 = new Destino();
        destino1.setId(1);
        destino1.setNombre("Los templos en Angkor");
        destino1.setPais("Camboya");
        destino1.setUbicacion("Asia y Oceanía");
        destino1.setDescripcion("es una región de Camboya que alojó las sucesivas capitales del Imperio jemer durante su época de esplendor");
        
        Destino destino2 = new Destino();
        destino2.setId(2);
        destino2.setNombre("Machu Picchu");
        destino2.setPais("Perú");
        destino2.setUbicacion("2.550 metros de altura en los Andes peruanos");
        destino2.setDescripcion("También conocida como la Ciudad Perdida de los incas");
       
        Destino destino3 = new Destino();
        destino3.setId(3);
        destino3.setNombre("La Gran Muralla China");
        destino3.setPais("China");
        destino3.setUbicacion("Fortificación china va desde la frontera con Corea hasta el desierto de Gobi");
        destino3.setDescripcion("De 21.196 kilómetros de largo. Fue declarada Patrimonio de la Humanidad por la Unesco.");

        destinos.add(destino1);
        destinos.add(destino2);
        destinos.add(destino3);
    }

    public List<Destino> getAll() throws Exception {
        try {
            return destinos;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Destino getById(int id) throws Exception {
        try {
            for(Destino item: destinos) {
                if(item.getId() == id) {
                    return item;
                }
            }
            return null;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Destino save(Destino destino) throws Exception {
        try {
            destinos.add(destino);
            return destino;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Destino update(Destino destino) throws Exception {
        try {
            for(Destino item: destinos) {
                if(item.getId() == destino.getId()) {
                    item.setNombre(destino.getNombre());
                    item.setPais(destino.getPais());
                    item.setUbicacion(destino.getUbicacion());
                    item.setDescripcion(destino.getDescripcion());
                    return item;
                }
            }
            return null;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<Destino> delete(int id) throws Exception {
        try {
            for(Destino item: destinos) {
                if(item.getId() == id) {
                    destinos.remove(item);
                    return destinos;
                }
            }
            throw new Exception("No se encontró el destino");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    
}
