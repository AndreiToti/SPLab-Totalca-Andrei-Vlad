public class Table : Element
{
    private string title;

    public Table(string title)
    {
        this.title = title;
    }

    public void print()
    {
        Console.WriteLine("Table: " + title);
    }

    public void add(Element element) => throw new NotSupportedException();
    public void remove(Element element) => throw new NotSupportedException();
    public Element get(int index) => throw new NotSupportedException();
}
