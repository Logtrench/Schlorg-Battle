import java.io.*;

class ScoreBoard {

  public static void main() {
    try {

      // This will read the old scoreboard
      BufferedReader br = new BufferedReader(new FileReader("ScoreBoard.txt"));

      // this will write the old scoreboard into a temporary
      BufferedWriter bwt = new BufferedWriter(new FileWriter("ScoreBoard-temp.txt"));

      // this will read the temporary
      BufferedReader brt = new BufferedReader(new FileReader("ScoreBoard-temp.txt"));

      // creation of a string to read
      String s;

      // will write everything from the original file into the temporary
      while ((s = br.readLine()) != null) {
        bwt.write(s + "\n");

      }

      // reset of old file and writer which will copy temp file into new file along
      // with new score
      BufferedWriter bw = new BufferedWriter(new FileWriter("ScoreBoard.txt"));

      // add new score to temp file when nothing is read
      if ((s = br.readLine()) == null) {
        bwt.write("**********\n");
        bwt.write("Scoreboard\n");
        bwt.write("Username: " + Main.username + "\n");
        bwt.write("Rounds took: " + Main.rounds + "\n");
        bwt.write("Ending: " + Main.ending + "\n");
        bwt.write("Difficulty: " + GUI.difficulty + "\n");
        bwt.write("Cheats: " + GUI.cheat + "\n");
        bwt.write("**********\n");

      }

      // close reader and writier for first file
      br.close();
      bwt.close();

      String t = "";
      while ((t = brt.readLine()) != null) {
        bw.write(t + "\n");
      }

      brt.close();

      bw.close();

      File newFile = new File("ScoreBoard-temp.txt");
      newFile.delete();

    } catch (FileNotFoundException e) {
      System.out.println("Creating ScoreBoard File...");
      try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("ScoreBoard.txt"));

        bw.write("**********\n");
        bw.write("Scoreboard\n");
        bw.write("Username: " + Main.username + "\n");
        bw.write("Rounds took: " + Main.rounds + "\n");
        bw.write("Ending: " + Main.ending + "\n");
        bw.write("Difficulty: " + GUI.difficulty + "\n");
        bw.write("Cheats: " + GUI.cheat + "\n");
        bw.write("**********\n");

        bw.close();
      } catch (Exception f) {
        System.out.println("WADWD");
      }

      return;
    } catch (Exception e) {
      System.out.println("ERROR IN BUFFER READER");

      return;
    }
  }

}