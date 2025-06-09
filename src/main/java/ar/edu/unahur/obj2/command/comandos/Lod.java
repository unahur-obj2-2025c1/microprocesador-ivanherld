package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Lod extends Command {
    private Integer addr;

    public Lod(Integer addr){ //Esta bien, que gil, le tengo que pasasr el addr
        this.addr = addr;
    }

    @Override
    public void doExecute(Programable micro) {
        micro.setAcumuladorA(micro.getAddr(addr)); 
    }

}
