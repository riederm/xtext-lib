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
public class ArrayExtensionsFloatTest {
  private float[] data;
  
  @Before
  public void init() {
    this.data = this.createData();
  }
  
  private float[] createData() {
    final float[] array = new float[3];
    array[0] = 10.0f;
    array[1] = 20.0f;
    array[2] = 30.0f;
    return array;
  }
  
  @Test
  public void testSetGet__float() {
    Assert.assertEquals(10.0f, this.data[0], 0.001f);
    Assert.assertEquals(20.0f, this.data[1], 0.001f);
    Assert.assertEquals(30.0f, this.data[2], 0.001f);
  }
  
  @Test
  public void testClone__float() {
    final float[] clonedData = this.data.clone();
    Assert.assertEquals(10.0f, clonedData[0], 0.001f);
    Assert.assertEquals(20.0f, clonedData[1], 0.001f);
    Assert.assertEquals(30.0f, clonedData[2], 0.001f);
  }
  
  @Test
  public void testLength__float() {
    Assert.assertEquals(3, this.data.length);
  }
  
  @Test
  public void testHashCode__float() {
    Assert.assertEquals(Objects.hashCode(this.data), this.data.hashCode());
  }
  
  @Test
  public void testEquals__float() {
    Assert.assertTrue(this.data.equals(this.data));
    Assert.assertFalse(this.data.equals(this.createData()));
    Assert.assertFalse(this.data.equals(new Object[3]));
    Assert.assertFalse(this.data.equals(null));
    float[] _createData = this.createData();
    final Procedure1<float[]> _function = (float[] it) -> {
      it[1] = 0.0f;
    };
    final float[] newData = ObjectExtensions.<float[]>operator_doubleArrow(_createData, _function);
    Assert.assertFalse(this.data.equals(newData));
  }
  
  @Test
  public void testContains__float() {
    Assert.assertTrue(ArrayExtensions.contains(this.data, 10.0f));
    Assert.assertTrue(ArrayExtensions.contains(this.data, 20.0f));
    Assert.assertTrue(ArrayExtensions.contains(this.data, 30.0f));
    Assert.assertFalse(ArrayExtensions.contains(this.data, 40.0f));
  }
}
