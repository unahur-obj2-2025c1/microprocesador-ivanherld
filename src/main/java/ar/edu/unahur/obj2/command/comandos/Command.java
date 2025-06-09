package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public abstract class Command implements Operable {

    @Override
    public void execute(Programable micro) {
        // TODO Auto-generated method stub
        doExecute(micro);
        micro.incProgramCounter();
        
    }

    @Override
    public void undo(Programable micro) {
        // TODO Auto-generated method stub
        
    }

    // Claro el public abstract tiene los override de la interface concretos, porque es comun a TODOS los comandos
    // El doExecute es el particular para cada comando, que va a hacer cosas con el tipo Programable que viene del micro
    public abstract void doExecute(Programable micro);
}
