public class Paragraph : Element
{
    private string text;

    public Paragraph(string text)
    {
        this.text = text;
    }

    public void print()
    {
        Console.WriteLine("Paragraph: " + text);
    }

    public void add(Element element)
    {
        throw new NotSupportedException();
    }

    public void remove(Element element)
    {
        throw new NotSupportedException();
    }

    public Element get(int index)
    {
        throw new NotSupportedException();
    }
}
