package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Str extends Command{

    private Integer addr;

     public Str(Integer addr){
        this.addr = addr;
    }

    @Override
    public void doExecute(Programable micro) {
        micro.setAddr(addr);
    }
}
