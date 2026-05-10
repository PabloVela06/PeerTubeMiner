package aiss.peertubeminer;
import aiss.peertubeminer.repositories.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialDataRunner implements CommandLineRunner {

    @Autowired
    ChannelRepository c;

    public InitialDataRunner(ChannelRepository c) {
        this.c = c;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Arrancando proceso de carga inicial automática...");

        try {
            Thread.sleep(15000);
            System.out.println("¡Lanzando la petición a PeerTube y enviando a VideoMiner!");
            c.create("tv",10,2,"guille6767");
            c.create("chem0013_videos",10,2,"guille6767");
            System.out.println("¡Carga inicial completada con éxito!");

        } catch (Exception e) {
            System.out.println("Error en la carga inicial: " + e.getMessage());
        }
    }
}