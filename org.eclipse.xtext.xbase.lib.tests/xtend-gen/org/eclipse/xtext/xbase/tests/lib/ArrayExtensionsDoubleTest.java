/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.lib;

import java.util.Objects;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Mathias Rieder - Initial contribution and API
 */
@SuppressWarnings("all")
public class ArrayExtensionsDoubleTest {
  private double[] data;
  
  @Before
  public void init() {
    this.data = this.createData();
  }
  
  private double[] createData() {
    final double[] array = new double[3];
    array[0] = 10.0;
    array[1] = 20.0;
    array[2] = 30.0;
    return array;
  }
  
  @Test
  public void testSetGet__double() {
    Assert.assertEquals(10.0, this.data[0], 0.001);
    Assert.assertEquals(20.0, this.data[1], 0.001);
    Assert.assertEquals(30.0, this.data[2], 0.001);
  }
  
  @Test
  public void testClone__double() {
    final double[] clonedData = this.data.clone();
    Assert.assertEquals(10.0, clonedData[0], 0.001);
    Assert.assertEquals(20.0, clonedData[1], 0.001);
    Assert.assertEquals(30.0, clonedData[2], 0.001);
  }
  
  @Test
  public void testLength__double() {
    Assert.assertEquals(3, this.data.length);
  }
  
  @Test
  public void testHashCode__double() {
    Assert.assertEquals(Objects.hashCode(this.data), this.data.hashCode());
  }
  
  @Test
  public void testEquals__double() {
    Assert.assertTrue(this.data.equals(this.data));
    Assert.assertFalse(this.data.equals(this.createData()));
    Assert.assertFalse(this.data.equals(new Object[3]));
    Assert.assertFalse(this.data.equals(null));
    double[] _createData = this.createData();
    final Procedure1<double[]> _function = (double[] it) -> {
      it[1] = 0.0;
    };
    final double[] newData = ObjectExtensions.<double[]>operator_doubleArrow(_createData, _function);
    Assert.assertFalse(this.data.equals(newData));
  }
  
  @Test
  public void testContains__double() {
    Assert.assertTrue(ArrayExtensions.contains(this.data, 10.0));
    Assert.assertTrue(ArrayExtensions.contains(this.data, 20.0));
    Assert.assertTrue(ArrayExtensions.contains(this.data, 30.0));
    Assert.assertFalse(ArrayExtensions.contains(this.data, 40.0));
  }
}
