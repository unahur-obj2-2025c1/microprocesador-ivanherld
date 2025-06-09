package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Add;
import ar.edu.unahur.obj2.command.comandos.LoadV;
import ar.edu.unahur.obj2.command.comandos.Lod;
import ar.edu.unahur.obj2.command.comandos.Nop;
import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.comandos.Str;
import ar.edu.unahur.obj2.command.comandos.Swap;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class ProgramBuilder {

    List<Operable> listaDeProgramas = new ArrayList<>(); //No hace falta definir privacidad
    
    public ProgramBuilder nop(){
        listaDeProgramas.add(new Nop()); //Me hago metodos que agreguen mis comandos a la lista
        return this;
    }

    public ProgramBuilder add(){
        listaDeProgramas.add(new Add());
        return this;
    }

    public ProgramBuilder swap(){
        listaDeProgramas.add(new Swap());
        return this;
    }

    public ProgramBuilder lod(Integer addr){
        listaDeProgramas.add(new Lod(addr));
        return this;
    }

    public ProgramBuilder str(Integer addr){
        listaDeProgramas.add(new Str(addr));
        return this;
    }
    public ProgramBuilder lodv(Integer val){
        listaDeProgramas.add(new LoadV(val));
        return this;
    }

    public List<Operable> build(){
        if (listaDeProgramas.isEmpty())
            throw new MicroException("No se puede buildear un programa sin operaciones");
        return listaDeProgramas;
    }
}
