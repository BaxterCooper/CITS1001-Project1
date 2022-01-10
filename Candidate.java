/**
 * Represents a candidate in the Antarctica election process.
 *
 * @author Baxter Cooper (22966805)
 * @version 1.1 2020
 */
public class Candidate
{
    // their name
    private String name;
    // their number of votes
    private int noOfVotes;
    // their number of first places 
    private double noOfWins;

    /**
     * Constructor for objects of class Candidate.
     */
    public Candidate(String name)
    {
       // TODO 6
       this.name = name;
       noOfVotes = 0;
       noOfWins = 0.0;
    }

    /**
     * Returns the candidate's name.
     */
    public String getName()
    {
       // TODO 7
       return name;
    }

    /**
     * Returns the number of votes obtained by the candidate.
     */
    public int getNoOfVotes()
    {
       // TODO 8
       return noOfVotes;
    }

    /**
     * Returns the number of wins obtained by the candidate.
     */
    public double getNoOfWins()
    {
       // TODO 9
       return noOfWins;
    }
    
    /**
     * Adds n votes to the candidate. 
     */
    public void addToCount(int n)
    {
       // TODO 10
       noOfVotes += n;
    }
    
    /**
     * Adds n wins to the candidate. 
     */
    public void addToWins(double n)
    {
       // TODO 11
       noOfWins += n;
    }

    /**
     * Returns a string reporting the candidate's result, 
     * rounding the number of wins to the nearest integer. 
     * See the sample output files for the required format. 
     */
    public String getStanding()
    {
       // TODO 12
       return name + " got " + noOfVotes + " votes and "
       + Math.round(noOfWins) + " wins";
    }
}
