package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by o.kaluzhin on 31.08.2016.
 */
public class EquastionTests {

  @Test
  public void test0(){
    Equasion e = new Equasion(1 ,1, 1);
    Assert.assertEquals(e.rootNumber(), 0);
  }

  @Test
  public void test1(){
    Equasion e = new Equasion(1 ,2, 1);
    Assert.assertEquals(e.rootNumber(), 1);
  }

  @Test
  public void test2(){
    Equasion e = new Equasion(1 , 5, 6);
    Assert.assertEquals(e.rootNumber(), 2);
  }

  @Test
  public void testLinear(){
    Equasion e = new Equasion(0 , 1, 1);
    Assert.assertEquals(e.rootNumber(), 1);
  }

  @Test
  public void testConstant(){
    Equasion e = new Equasion(0, 0, 1);
    Assert.assertEquals(e.rootNumber(), 0);
  }

  @Test
  public void testZero(){
    Equasion e = new Equasion(0, 0, 0);
    Assert.assertEquals(e.rootNumber(), -1);
  }
}

