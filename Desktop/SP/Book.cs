using System;
using System.Collections.Generic;
using System.ComponentModel;

class Book
{
    public string Title;
    public List<Element> elements = new List<Element>();
    public List<Author> authors;


    public Book(string title)
    {
        Title = title;
    }
    public Book(List<Element> elements, List<Author> authors)
    {
        this.elements = elements;
        this.authors = authors;
    }

    public void AddAuthor(Author author)
    {
        if (authors == null)
            authors = new List<Author>();
        authors.Add(author);
    }

    public void addContent(Element element)
    {
        if (elements == null)
            elements = new List<Element>();
        elements.Add(element);
    }
    public void print_details()
    {
        Console.WriteLine("Book: " + Title);
        Console.WriteLine();
        Console.WriteLine("Autori:");
        foreach (var author in authors)
        {
            author.printName();
            author.print("\n");
        }

        Console.WriteLine("Elemente:");
        foreach (var e in elements)
        {
            e.print();
        }

    }
}