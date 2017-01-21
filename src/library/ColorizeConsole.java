/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author alvian
 */

public class ColorizeConsole extends PrintWriter{

    public enum Console {

        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        PURPLE("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m");

        private String ansiColor;

        Console(String ansiColor) {
          this.ansiColor = ansiColor;
        }

        public String getAnsiColor() {
          return ansiColor;
        }
    }

  private static final String ANSI_RESET = "\u001B[0m";

  public ColorizeConsole(PrintStream out) throws UnsupportedEncodingException {
    super(new OutputStreamWriter(out, "UTF-8"), true);
  }

  public void println(Console color, String string) {
    print(color.getAnsiColor());
    print(string);
    println(ANSI_RESET);
    flush();
  }

  public void green(String string) {
    println(Console.GREEN, string);
  }

  public void red(String string) {
    println(Console.RED, string);
  }

  public void black(String string) {
    println(Console.BLACK, string);
  }

  public void blue(String string) {
    println(Console.BLUE, string);
  }

  public void yellow(String string) {
    println(Console.YELLOW, string);
  }

  public void purple(String string) {
    println(Console.PURPLE, string);
  }

  public void cyan(String string) {
    println(Console.CYAN, string);
  }

  public void white(String string) {
    println(Console.WHITE, string);
  }
}
