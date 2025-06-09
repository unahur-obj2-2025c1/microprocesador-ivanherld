package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class Add extends Command {

    @Override
    public void doExecute(Programable micro) {
        Integer sum = micro.getAcumuladorA() + micro.getAcumuladorB();
        micro.setAcumuladorA(sum);
        micro.setAcumuladorB(0);
    }

}
