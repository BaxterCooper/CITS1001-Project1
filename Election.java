/**
 * Manages the Antarctica election process. 
 *
 * @author Baxter Cooper (22966805)
 * @version 1.1 2020
 */
import java.util.ArrayList;

public class Election
{
    // the list of candidates
    private ArrayList<Candidate> candidates;
    // the list of voting papers
    private ArrayList<VotingPaper> papers;
    // the file of election information
    private FileIO file;

    /**
     * Constructor for objects of class Election.
     * Creates the three field objects.
     */
    public Election(String filename)
    {
       // TODO 13
       candidates = new ArrayList<>();
       papers = new ArrayList<>();
       file = new FileIO(filename);
    }
    
    /**
     * Constructor for objects of class Election with default files.
     * It uses k to select from the sample input files.
     */
    public Election(int k)
    {
       this("election" + k + ".txt");
    }
    
    /**
     * Returns the candidates list.
     */
    public ArrayList<Candidate> getCandidates()
    {
       // TODO 14
       return candidates;
    }
    
    /**
     * Returns the papers list.
     */
    public ArrayList<VotingPaper> getPapers()
    {
       // TODO 15
       return papers;
    }
    
    /**
     * Returns the read-in file contents.
     */
    public ArrayList<String> getFile()
    {
       // TODO 16
       return file.getLines();
    }
    
    /**
     * Use the file information to initialise the other two fields.
     * Reads the candidates, then discards exactly one blank line, then reads the voting papers.
     * See the sample input files for examples of the format.
     */
    public void processFile() 
    {
       // TODO 17
       int indexp = 0;
       for(int index = 0; !getFile().get(index).isEmpty(); index++) {
           Candidate name = new Candidate(getFile().get(index));
           candidates.add(name);
           indexp = index + 2;
       }
       
       while(indexp < getFile().size()) {
           VotingPaper paper = new VotingPaper(getFile().get(indexp));
           papers.add(paper);
           indexp ++;
       }
    }
    
    /**
     * Adds each formal vote to each candidate, both numbers of votes and numbers of wins.
     * Returns the number of informal votes.
     */
    public int conductCount()
    {
       // TODO 21
       int informal = 0;
       for(VotingPaper paper : papers) {
           if(!paper.isFormal(candidates.size())) {
               informal += 1;
           }
           if(paper.isFormal(candidates.size())) {
               paper.updateVoteCounts(candidates);
               paper.updateWinCounts(candidates);
           }
       }
       return informal;
    }

    /**
     * Returns and prints a summary of the election result. 
     * See the sample output files for the required format. 
     */
    public String getStandings()
    {
       // TODO 22
       String summary = null;
       String o = "";
       for(Candidate candidate : candidates) {
            summary = candidate.getStanding() + "\n";
            o += summary;
            System.out.println(summary);
       }
       return o;
    }   
    
    /**
     * Returns the winner of the election. 
     * Selects the candidate with the highest number of votes; if multiple 
     * candidates are equal, selects the one with the highest number of wins. 
    */
    public Candidate winner()
    {
       // TODO 23
       int index = 0;
       int votes = 0;
       double wins = 0;
       Candidate winner = null;
       for(Candidate name : candidates) {
           if(name.getNoOfVotes() > votes) {
               winner = candidates.get(index);
               wins = name.getNoOfWins();
               votes = name.getNoOfVotes();
           }
           if(name.getNoOfVotes() == votes && name.getNoOfWins() > wins) {  
               winner = candidates.get(index);
               wins = name.getNoOfWins();
           }    
           index ++;
       }
       return winner; 
    }   
}       