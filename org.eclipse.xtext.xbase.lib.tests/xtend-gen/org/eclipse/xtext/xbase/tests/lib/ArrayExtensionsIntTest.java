/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.lib;

import java.util.List;
import java.util.Objects;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Mathias Rieder - Initial contribution and API
 */
@SuppressWarnings("all")
public class ArrayExtensionsIntTest {
  private int[] data;
  
  @Before
  public void init() {
    this.data = this.createData();
  }
  
  private int[] createData() {
    final int[] array = new int[3];
    array[0] = 10;
    array[1] = 20;
    array[2] = 30;
    return array;
  }
  
  @Test
  public void testSetGet__int() {
    Assert.assertEquals(10, this.data[0]);
    Assert.assertEquals(20, this.data[1]);
    Assert.assertEquals(30, this.data[2]);
  }
  
  @Test
  public void testClone__int() {
    final int[] clonedData = this.data.clone();
    Assert.assertEquals(10, clonedData[0]);
    Assert.assertEquals(20, clonedData[1]);
    Assert.assertEquals(30, clonedData[2]);
  }
  
  @Test
  public void testLength__int() {
    Assert.assertEquals(3, this.data.length);
  }
  
  @Test
  public void testHashCode__int() {
    Assert.assertEquals(Objects.hashCode(this.data), this.data.hashCode());
  }
  
  @Test
  public void testEquals__int() {
    Assert.assertTrue(this.data.equals(this.data));
    Assert.assertFalse(this.data.equals(this.createData()));
    Assert.assertFalse(this.data.equals(new Object[3]));
    Assert.assertFalse(this.data.equals(null));
    int[] _createData = this.createData();
    final Procedure1<int[]> _function = (int[] it) -> {
      it[1] = 0;
    };
    final int[] newData = ObjectExtensions.<int[]>operator_doubleArrow(_createData, _function);
    Assert.assertFalse(this.data.equals(newData));
  }
  
  @Test
  public void testContains__int() {
    Assert.assertTrue(((List<Integer>)Conversions.doWrapArray(this.data)).contains(Integer.valueOf(10)));
    Assert.assertTrue(((List<Integer>)Conversions.doWrapArray(this.data)).contains(Integer.valueOf(20)));
    Assert.assertTrue(((List<Integer>)Conversions.doWrapArray(this.data)).contains(Integer.valueOf(30)));
    Assert.assertFalse(((List<Integer>)Conversions.doWrapArray(this.data)).contains(Integer.valueOf(40)));
  }
}
