package comparing;

public class Question implements Comparable<Question> {
    private int id;
    private double score;
    private String content;

    public Question(int id, double score, String content) {
        this.id = id;
        this.score = score;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", score=" + score +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public int compareTo(Question that) {
        // ORDER BY content ASC
        return this.content.compareTo(that.content);

        // ORDER BY id DESC
        // return Integer.compare(that.id, this.id);

        // ORDER BY id ASC
        // return Integer.compare(this.id, that.id);
    }
}
