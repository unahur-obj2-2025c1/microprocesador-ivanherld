package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class Microprocesador implements Programable {

    private Integer acumuladorA = 0;
    private Integer acumuladorB = 0;
    private Integer programCounter = 0;
    private List<Integer> memoriaDatos = new ArrayList<>(1024);



    @Override
    public Programable copy() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void copyFrom(Programable programable) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Integer getAcumuladorA() {
        return this.acumuladorA;
    }

    @Override
    public Integer getAcumuladorB() {
        return this.acumuladorB;
    }

    @Override
    public Integer getAddr(Integer addr) {
        return memoriaDatos.get(addr);
    }

    @Override
    public Integer getProgramCounter() {
        return this.programCounter;
    }

    @Override
    public void incProgramCounter() {
        programCounter ++;
        
    }

    @Override
    public void reset() {
        this.acumuladorA = 0;
        this.acumuladorB = 0;
        this.programCounter = 0;
        memoriaDatos = new ArrayList<>(1024);
        
    }

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.stream().forEach(operacion -> operacion.execute(this)); //execute es el metodo de la interface OJO
        
    }

    @Override
    public void setAcumuladorA(Integer value) {
        this.acumuladorA = value;   
    }

    @Override
    public void setAcumuladorB(Integer value) {
        this.acumuladorB = value;  
    }

    @Override
    public void setAddr(Integer addr) {

        if (addr == null) {
        throw new MicroException("La dirección no puede ser null.");
        }

        if (addr >= 0 && addr < 1024) //Podría haber hecho un estaEnRango
         {
            memoriaDatos.set(addr, acumuladorA); //Port lo visto setAddr solo debería acumular A
        }
         else {throw new MicroException("Esta fuera del rango de memoria");}

    }

    
}