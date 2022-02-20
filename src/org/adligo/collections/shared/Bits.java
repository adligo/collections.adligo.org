package org.adligo.collections.shared;


/**
 * This contains a pre calculated method that counts the bits in
 * a byte
 * 
 * @author scott
 *
 * <pre><code>
 * ---------------- Apache ICENSE-2.0 --------------------------
 *
 * Copyright 2022 Adligo Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </code><pre>
 */
public class Bits {
  
  /**
   * This was accomplished by BitsSourceFileTrial
   * in the test project
   * @param b
   * @return
   */
  public static int countBits(byte b) {
    switch (b) {
      case (byte) 0x00: //no break
        return 0;
      case (byte) 0x80: //no break
      case (byte) 0x01: //no break
      case (byte) 0x02: //no break
      case (byte) 0x04: //no break
      case (byte) 0x08: //no break
      case (byte) 0x10: //no break
      case (byte) 0x20: //no break
      case (byte) 0x40: //no break
        return 1;
      case (byte) 0x81: //no break
      case (byte) 0x82: //no break
      case (byte) 0x84: //no break
      case (byte) 0x88: //no break
      case (byte) 0x90: //no break
      case (byte) 0xA0: //no break
      case (byte) 0xC0: //no break
      case (byte) 0x03: //no break
      case (byte) 0x05: //no break
      case (byte) 0x06: //no break
      case (byte) 0x09: //no break
      case (byte) 0x0A: //no break
      case (byte) 0x0C: //no break
      case (byte) 0x11: //no break
      case (byte) 0x12: //no break
      case (byte) 0x14: //no break
      case (byte) 0x18: //no break
      case (byte) 0x21: //no break
      case (byte) 0x22: //no break
      case (byte) 0x24: //no break
      case (byte) 0x28: //no break
      case (byte) 0x30: //no break
      case (byte) 0x41: //no break
      case (byte) 0x42: //no break
      case (byte) 0x44: //no break
      case (byte) 0x48: //no break
      case (byte) 0x50: //no break
      case (byte) 0x60: //no break
        return 2;
      case (byte) 0x83: //no break
      case (byte) 0x85: //no break
      case (byte) 0x86: //no break
      case (byte) 0x89: //no break
      case (byte) 0x8A: //no break
      case (byte) 0x8C: //no break
      case (byte) 0x91: //no break
      case (byte) 0x92: //no break
      case (byte) 0x94: //no break
      case (byte) 0x98: //no break
      case (byte) 0xA1: //no break
      case (byte) 0xA2: //no break
      case (byte) 0xA4: //no break
      case (byte) 0xA8: //no break
      case (byte) 0xB0: //no break
      case (byte) 0xC1: //no break
      case (byte) 0xC2: //no break
      case (byte) 0xC4: //no break
      case (byte) 0xC8: //no break
      case (byte) 0xD0: //no break
      case (byte) 0xE0: //no break
      case (byte) 0x07: //no break
      case (byte) 0x0B: //no break
      case (byte) 0x0D: //no break
      case (byte) 0x0E: //no break
      case (byte) 0x13: //no break
      case (byte) 0x15: //no break
      case (byte) 0x16: //no break
      case (byte) 0x19: //no break
      case (byte) 0x1A: //no break
      case (byte) 0x1C: //no break
      case (byte) 0x23: //no break
      case (byte) 0x25: //no break
      case (byte) 0x26: //no break
      case (byte) 0x29: //no break
      case (byte) 0x2A: //no break
      case (byte) 0x2C: //no break
      case (byte) 0x31: //no break
      case (byte) 0x32: //no break
      case (byte) 0x34: //no break
      case (byte) 0x38: //no break
      case (byte) 0x43: //no break
      case (byte) 0x45: //no break
      case (byte) 0x46: //no break
      case (byte) 0x49: //no break
      case (byte) 0x4A: //no break
      case (byte) 0x4C: //no break
      case (byte) 0x51: //no break
      case (byte) 0x52: //no break
      case (byte) 0x54: //no break
      case (byte) 0x58: //no break
      case (byte) 0x61: //no break
      case (byte) 0x62: //no break
      case (byte) 0x64: //no break
      case (byte) 0x68: //no break
      case (byte) 0x70: //no break
        return 3;
      case (byte) 0x87: //no break
      case (byte) 0x8B: //no break
      case (byte) 0x8D: //no break
      case (byte) 0x8E: //no break
      case (byte) 0x93: //no break
      case (byte) 0x95: //no break
      case (byte) 0x96: //no break
      case (byte) 0x99: //no break
      case (byte) 0x9A: //no break
      case (byte) 0x9C: //no break
      case (byte) 0xA3: //no break
      case (byte) 0xA5: //no break
      case (byte) 0xA6: //no break
      case (byte) 0xA9: //no break
      case (byte) 0xAA: //no break
      case (byte) 0xAC: //no break
      case (byte) 0xB1: //no break
      case (byte) 0xB2: //no break
      case (byte) 0xB4: //no break
      case (byte) 0xB8: //no break
      case (byte) 0xC3: //no break
      case (byte) 0xC5: //no break
      case (byte) 0xC6: //no break
      case (byte) 0xC9: //no break
      case (byte) 0xCA: //no break
      case (byte) 0xCC: //no break
      case (byte) 0xD1: //no break
      case (byte) 0xD2: //no break
      case (byte) 0xD4: //no break
      case (byte) 0xD8: //no break
      case (byte) 0xE1: //no break
      case (byte) 0xE2: //no break
      case (byte) 0xE4: //no break
      case (byte) 0xE8: //no break
      case (byte) 0xF0: //no break
      case (byte) 0x0F: //no break
      case (byte) 0x17: //no break
      case (byte) 0x1B: //no break
      case (byte) 0x1D: //no break
      case (byte) 0x1E: //no break
      case (byte) 0x27: //no break
      case (byte) 0x2B: //no break
      case (byte) 0x2D: //no break
      case (byte) 0x2E: //no break
      case (byte) 0x33: //no break
      case (byte) 0x35: //no break
      case (byte) 0x36: //no break
      case (byte) 0x39: //no break
      case (byte) 0x3A: //no break
      case (byte) 0x3C: //no break
      case (byte) 0x47: //no break
      case (byte) 0x4B: //no break
      case (byte) 0x4D: //no break
      case (byte) 0x4E: //no break
      case (byte) 0x53: //no break
      case (byte) 0x55: //no break
      case (byte) 0x56: //no break
      case (byte) 0x59: //no break
      case (byte) 0x5A: //no break
      case (byte) 0x5C: //no break
      case (byte) 0x63: //no break
      case (byte) 0x65: //no break
      case (byte) 0x66: //no break
      case (byte) 0x69: //no break
      case (byte) 0x6A: //no break
      case (byte) 0x6C: //no break
      case (byte) 0x71: //no break
      case (byte) 0x72: //no break
      case (byte) 0x74: //no break
      case (byte) 0x78: //no break
        return 4;
      case (byte) 0x8F: //no break
      case (byte) 0x97: //no break
      case (byte) 0x9B: //no break
      case (byte) 0x9D: //no break
      case (byte) 0x9E: //no break
      case (byte) 0xA7: //no break
      case (byte) 0xAB: //no break
      case (byte) 0xAD: //no break
      case (byte) 0xAE: //no break
      case (byte) 0xB3: //no break
      case (byte) 0xB5: //no break
      case (byte) 0xB6: //no break
      case (byte) 0xB9: //no break
      case (byte) 0xBA: //no break
      case (byte) 0xBC: //no break
      case (byte) 0xC7: //no break
      case (byte) 0xCB: //no break
      case (byte) 0xCD: //no break
      case (byte) 0xCE: //no break
      case (byte) 0xD3: //no break
      case (byte) 0xD5: //no break
      case (byte) 0xD6: //no break
      case (byte) 0xD9: //no break
      case (byte) 0xDA: //no break
      case (byte) 0xDC: //no break
      case (byte) 0xE3: //no break
      case (byte) 0xE5: //no break
      case (byte) 0xE6: //no break
      case (byte) 0xE9: //no break
      case (byte) 0xEA: //no break
      case (byte) 0xEC: //no break
      case (byte) 0xF1: //no break
      case (byte) 0xF2: //no break
      case (byte) 0xF4: //no break
      case (byte) 0xF8: //no break
      case (byte) 0x1F: //no break
      case (byte) 0x2F: //no break
      case (byte) 0x37: //no break
      case (byte) 0x3B: //no break
      case (byte) 0x3D: //no break
      case (byte) 0x3E: //no break
      case (byte) 0x4F: //no break
      case (byte) 0x57: //no break
      case (byte) 0x5B: //no break
      case (byte) 0x5D: //no break
      case (byte) 0x5E: //no break
      case (byte) 0x67: //no break
      case (byte) 0x6B: //no break
      case (byte) 0x6D: //no break
      case (byte) 0x6E: //no break
      case (byte) 0x73: //no break
      case (byte) 0x75: //no break
      case (byte) 0x76: //no break
      case (byte) 0x79: //no break
      case (byte) 0x7A: //no break
      case (byte) 0x7C: //no break
        return 5;
      case (byte) 0x9F: //no break
      case (byte) 0xAF: //no break
      case (byte) 0xB7: //no break
      case (byte) 0xBB: //no break
      case (byte) 0xBD: //no break
      case (byte) 0xBE: //no break
      case (byte) 0xCF: //no break
      case (byte) 0xD7: //no break
      case (byte) 0xDB: //no break
      case (byte) 0xDD: //no break
      case (byte) 0xDE: //no break
      case (byte) 0xE7: //no break
      case (byte) 0xEB: //no break
      case (byte) 0xED: //no break
      case (byte) 0xEE: //no break
      case (byte) 0xF3: //no break
      case (byte) 0xF5: //no break
      case (byte) 0xF6: //no break
      case (byte) 0xF9: //no break
      case (byte) 0xFA: //no break
      case (byte) 0xFC: //no break
      case (byte) 0x3F: //no break
      case (byte) 0x5F: //no break
      case (byte) 0x6F: //no break
      case (byte) 0x77: //no break
      case (byte) 0x7B: //no break
      case (byte) 0x7D: //no break
      case (byte) 0x7E: //no break
        return 6;
      case (byte) 0xBF: //no break
      case (byte) 0xDF: //no break
      case (byte) 0xEF: //no break
      case (byte) 0xF7: //no break
      case (byte) 0xFB: //no break
      case (byte) 0xFD: //no break
      case (byte) 0xFE: //no break
        return 7;
      //case (byte) 0xFF: //no break
      default:
        return 8;
    }
  }
}
