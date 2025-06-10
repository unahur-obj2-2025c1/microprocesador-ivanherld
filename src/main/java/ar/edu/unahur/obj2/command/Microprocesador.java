package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class Microprocesador implements Programable {

    private Integer acumuladorA = 0;
    private Integer acumuladorB = 0;
    private Integer programCounter = 0;
    List<Integer> memoriaDatos = Arrays.asList(new Integer[1024]);

    public Microprocesador(Integer acumuladorA, Integer acumuladorB, Integer programCounter){
        this.acumuladorA = acumuladorA;
        this.acumuladorB = acumuladorB;
        this.programCounter = programCounter;
    }

    @Override
    public Programable copy() {
        return new Microprocesador(this.acumuladorA, this.acumuladorB, this.programCounter);
    }

    @Override
    public void copyFrom(Programable programable) {
        this.acumuladorA = programable.getAcumuladorA();
        this.acumuladorB = programable.getAcumuladorB();
        this.programCounter = programable.getProgramCounter();
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
        memoriaDatos = Arrays.asList(new Integer[1024]);
        
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