public class Section : Element
{
    private string title;
    private List<Element> elements;

    public Section(string title)
    {
        this.title = title;
    }

    public void add(Element element)
    {
        if (elements == null)
            elements = new List<Element>();
        elements.Add(element);
    }

    public void remove(Element element)
    {
        elements.Remove(element);
    }

    public Element get(int index)
    {
        return elements[index];
    }

    public void print()
    {
        Console.WriteLine(title);
        foreach (var e in elements)
        {
            e.print();
        }
    }
}
