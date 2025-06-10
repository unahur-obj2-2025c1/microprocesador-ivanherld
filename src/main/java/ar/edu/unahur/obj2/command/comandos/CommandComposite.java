package ar.edu.unahur.obj2.command.comandos;

import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class CommandComposite extends Command{
        protected List<Operable> listaOperaciones;

        @Override
        public void doExecute(Programable micro) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'doExecute'");
        }
}
