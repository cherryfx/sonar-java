package checks.regex;

public class SingleCharacterAlternationCheck {

  void nonCompliant() {
    String str = "abc123";
    str.matches("a|b|c"); // Noncompliant [[sc=18;ec=23]] {{Replace this alternation with a character class.}}
    str.matches("a|(b|c)"); // Noncompliant [[sc=21;ec=24]]
    str.matches("abcd|(e|f)gh"); // Noncompliant [[sc=24;ec=27]]
    str.matches("(a|b|c)*"); // Noncompliant [[sc=19;ec=24]]
    str.matches("\\d|x"); // Noncompliant [sc=18;ec=23]]
    str.matches("\\P{L}|\\d"); // Noncompliant [sc=18;ec=28]]
    str.matches("\\u1234|\\x{12345}"); // Noncompliant [sc=18;ec=36]]
  }

  void compliant() {
    String str = "abc123";
    str.matches("ab|cd");
    str.matches("a|\\b|c");
    str.matches("^|$");
    str.matches("|");
  }

}
