package ar.edu.unahur.obj2.command.comandos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.ProgramBuilder;
import ar.edu.unahur.obj2.command.Programable;

public class CommandTest {
    // Programable programable = new Microprocesador();

    // @BeforeEach
    // void setUp() {
    //     programable.reset();
    // }

    // @Test
    // void testExecute() {
    //     Operable lodv20 = new LoadV(20);
    //     Operable swap = new Swap();
    //     Operable lodv17 = new LoadV(17);
    //     Operable suma = new Add();

    //     lodv20.execute(programable);
    //     swap.execute(programable);
    //     lodv17.execute(programable);
    //     suma.execute(programable);
    //     suma.undo(programable);

    //     assertEquals(37, programable.getAcumuladorA());
    //     assertEquals(0, programable.getAcumuladorB());
    //     assertEquals(4, programable.getProgramCounter());
    // }

     @Test
    void alBuildearUnProgramaConInstruccionesSimples_CuandoSeLoPasamosAUnMicrocontrolador_FuncionaCorrectamente() {
        Programable programable = new Microprocesador();
        ProgramBuilder programBuilder = new ProgramBuilder();

        programable.run(
                programBuilder
                        .lodv(2)
                        .str(0)
                        .lodv(8)
                        .swap()
                        .lodv(5)
                        .add()
                        .swap()
                        .lod(0)
                        .add().build());

        assertEquals(15, programable.getAcumuladorA());
        assertEquals(0, programable.getAcumuladorB());
        assertEquals(9, programable.getProgramCounter());
    }
}
