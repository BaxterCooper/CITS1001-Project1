/**
 * Represents a voting paper in the Antarctica election process. 
 *
 * @author Baxter Cooper (22966805)
 * @version 1.1 2020
 */
import java.util.ArrayList;
 
public class VotingPaper
{
    // the numbers marked on the paper 
    private ArrayList<Integer> marks;

    /**
     * Constructor for objects of class VotingPaper. 
     * s will be a (possibly empty) sequence of integers, separated by commas. 
     * e.g. if s is "1,22,-13,456", marks is set to <1,22,-13,456>. 
     */
    public VotingPaper(String s)
    {
       marks = new ArrayList<>();
       if (!s.isEmpty())
          for (String x : s.split(",")) 
              marks.add(Integer.parseInt(x));
    }
    
    /**
     * Returns the contents of the paper.
     */
    public ArrayList<Integer> getMarks()
    {
       // TODO 1
       return marks;
    }

    /**
     * Returns true iff the paper has the correct number of marks, 
     * i.e. one for each candidate. 
     */
    public boolean isCorrectLength(int noOfCandidates)
    {
       // TODO 2
       if (noOfCandidates == marks.size()) {
           return true;       
       }
       else {
           return false;
       }
    }

    /**
     * Returns true iff the sum of the marks is legal, 
     * i.e. no more than total. 
     */
    public boolean isLegalTotal(int total)
    {
       // TODO 3
       int sum = 0;
       for(int index = 0; index < marks.size(); index++) {
             sum += marks.get(index);
       }
        
       if(total >= sum) {
            return true;
       }
       else {
            return false;
       }
    }

    /**
     * Returns true iff there are negative marks. 
     */
    public boolean anyNegativeMarks()
    {
       // TODO 4
       for(int mark : marks) {
           if (mark < 0) {
                return true;
           }
       }
       return false;
    }

    /**
     * Returns true iff the paper is formal. 
     * It must be the right length with no negative marks and a legal total. 
     */
    public boolean isFormal(int noOfCandidates)
    {
       // TODO 5
       if ((isCorrectLength(noOfCandidates) == true) 
       && (isLegalTotal(noOfCandidates) == true) 
       && (anyNegativeMarks() == false)) {
            return true;
       }
       else {
            return false;
       }
    }
    
    /**
     * Adds the appropriate number of votes to each candidate.
     * The kth number goes to the kth candidate.
     */
    public void updateVoteCounts(ArrayList<Candidate> cs)
    {
       // TODO 18
       int index = 0;
       for(Candidate name: cs) {
            name.addToCount(marks.get(index));
            index ++;
       }
    }
    
    /**
     * Returns the indices in marks which have the highest number.
     * e.g. if marks = <4,4,1,5,2>, it returns <3> (because the highest number is at index 3).
     * e.g. if marks = <5,4,1,2,5>, it returns <0,4>.
     * e.g. if marks = <1,1,1,1,1>, it returns <0,1,2,3,4>.
     */
    public ArrayList<Integer> highestVote()
    {
       // TODO 19
       int max = marks.get(0);
       ArrayList<Integer> index = new ArrayList<>();
       for(int i=0; i < marks.size(); i++) {
           if(marks.get(i) > max) {
               max = marks.get(i);
           }
       }
       
       for(int u=0; u < marks.size(); u++) {
           if(marks.get(u) == max) {
               index.add(u);
           }
       }
       return index;
    }
    
    /**
     * Adds the appropriate number of wins to each candidate.
     * If there are n equal-highest numbers, each of those 
     * candidates receives 1/n wins. 
     */
    public void updateWinCounts(ArrayList<Candidate> cs)
    {
       // TODO 20
       int index = 0;
       double win = 1.0/highestVote().size();
       for(Candidate name: cs) {
          if(highestVote().contains(index)) {
              name.addToWins(win);
            }
          index ++;  
       }
    }
}
