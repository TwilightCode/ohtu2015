package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    Statistics statistics;
    double vertailuTarkkuus = 0.0001;
    public StatisticsTest() {
        
    }
    @Before
       public void setUp() {
       
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    this.statistics = new Statistics(readerStub);
    }
      @Test
      public void etsiPelaaja(){
          assertEquals("Semenko", statistics.search("Semenko").getName());
      }
      
      @Test
      public void etsiPelaajaJotaEiOle(){
          assertEquals(null, statistics.search("Garry"));
      }
      
      @Test
      public void listaaTeam(){
          assertEquals(3, statistics.team("EDM").size());
      }
      
       @Test
      public void topListaus(){
          List<Player> testiTaulu = statistics.topScorers(2);
          assertEquals(3, testiTaulu.size());
          assertEquals("Gretzky", testiTaulu.get(0).getName());
          assertEquals("Yzerman", testiTaulu.get(2).getName());
      }
}
