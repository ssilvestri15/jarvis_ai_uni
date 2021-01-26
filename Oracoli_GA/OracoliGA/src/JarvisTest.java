import fitness.ConflictsFunction;
import individuals.ClassRoomIndividual;
import initializers.FixedSizeClassRoomInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import metaheuristic.SimpleGeneticAlgorithm;
import operators.ClassRoomSinglePointCrossover;
import operators.ClassRoomSwapMutation;
import operators.RouletteWheelSelection;
import results.Results;

public class JarvisTest {

  private static final int classSize = 20;


  public static void main(String[] args) throws CloneNotSupportedException {
    
    int[] prenotazioniList = new int[classSize];

    prenotazioniList[0] = 1;
    prenotazioniList[1] = 0;
    prenotazioniList[2] = 0;
    prenotazioniList[3] = 0;
    prenotazioniList[4] = 0;
    prenotazioniList[5] = 1;
    prenotazioniList[6] = 0;
    prenotazioniList[7] = 0;
    prenotazioniList[8] = 1;
    prenotazioniList[9] = 1;
    prenotazioniList[10] = 0;
    prenotazioniList[11] = 0;
    prenotazioniList[12] = 0;
    prenotazioniList[13] = 1;
    prenotazioniList[14] = 0;
    prenotazioniList[15] = 0;
    prenotazioniList[16] = 0;
    prenotazioniList[17] = 1;
    prenotazioniList[18] = 0;
    prenotazioniList[19] = 1;

    Jarvis.disponiPrenotazione(prenotazioniList);

  }

}




