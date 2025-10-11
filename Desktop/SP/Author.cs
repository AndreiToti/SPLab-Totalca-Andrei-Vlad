class Author
{
    public string Name;

    public Author(string name)
    {
        Name = name;
    }

    public void printName()
    {
        System.Console.WriteLine(Name);
    }

    public void print(string st)
    {
        System.Console.Write(st);
    }
}