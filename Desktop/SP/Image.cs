public class Image : Element
{
    private string url;

    public Image(string url)
    {
        this.url = url;
    }

    public void print()
    {
        Console.WriteLine("Image with name: " + url);
    }

    public void add(Element element) => throw new NotSupportedException();
    public void remove(Element element) => throw new NotSupportedException();
    public Element get(int index) => throw new NotSupportedException();
}
