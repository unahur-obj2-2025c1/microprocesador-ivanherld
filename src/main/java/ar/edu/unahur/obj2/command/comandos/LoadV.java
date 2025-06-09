package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LoadV extends Command {

    private Integer val;


     public LoadV(Integer val){
        this.val = val;
    }

    @Override
    public void doExecute(Programable micro) {
        micro.setAcumuladorA(val);
    }

   
}
