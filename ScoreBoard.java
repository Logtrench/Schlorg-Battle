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
        bwt.write("Finishing Health: " + Main.you.getHealth() + "\n");
        bwt.write("Cheats: " + GUI.cheat + "\n");
        bwt.write("**********\n");

      }

      // close reader and writier for first file so that others can right
      br.close();
      bwt.close();

      //writing the temp file into the scoreboard
      String t = "";
      while ((t = brt.readLine()) != null) {
        bw.write(t + "\n");
      }

      //closing the other reader and writer
      brt.close();
      bw.close();

      //deleting the Scoreboard temp file
      File newFile = new File("ScoreBoard-temp.txt");
      newFile.delete();

    } catch (FileNotFoundException e) {
      //if no file is found, create a new file
      System.out.println("Creating ScoreBoard File...");
      try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("ScoreBoard.txt"));

        //add score
        bw.write("**********\n");
        bw.write("Scoreboard\n");
        bw.write("Username: " + Main.username + "\n");
        bw.write("Rounds took: " + Main.rounds + "\n");
        bw.write("Ending: " + Main.ending + "\n");
        bw.write("Difficulty: " + GUI.difficulty + "\n");
        bw.write("Finishing Health: " + Main.you.getHealth() + "\n");
        bw.write("Cheats: " + GUI.cheat + "\n");
        bw.write("**********\n");

        //close writer
        bw.close();
      } catch (Exception f) {
        //print there was an error
        System.out.println("There was an error in the bufferReader, when there was no file");
      }

      return;
    } catch (Exception e) {
        //print if there was an error
      System.out.println("There was an error in the bufferReader, already having a file");

      return;
    }
  }

}