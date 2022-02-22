package org.adligo.collections.shared.common;


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
      case (byte) 0xa0: //no break
      case (byte) 0xc0: //no break
      case (byte) 0x03: //no break
      case (byte) 0x05: //no break
      case (byte) 0x06: //no break
      case (byte) 0x09: //no break
      case (byte) 0x0a: //no break
      case (byte) 0x0c: //no break
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
      case (byte) 0x8a: //no break
      case (byte) 0x8c: //no break
      case (byte) 0x91: //no break
      case (byte) 0x92: //no break
      case (byte) 0x94: //no break
      case (byte) 0x98: //no break
      case (byte) 0xa1: //no break
      case (byte) 0xa2: //no break
      case (byte) 0xa4: //no break
      case (byte) 0xa8: //no break
      case (byte) 0xb0: //no break
      case (byte) 0xc1: //no break
      case (byte) 0xc2: //no break
      case (byte) 0xc4: //no break
      case (byte) 0xc8: //no break
      case (byte) 0xd0: //no break
      case (byte) 0xe0: //no break
      case (byte) 0x07: //no break
      case (byte) 0x0b: //no break
      case (byte) 0x0d: //no break
      case (byte) 0x0e: //no break
      case (byte) 0x13: //no break
      case (byte) 0x15: //no break
      case (byte) 0x16: //no break
      case (byte) 0x19: //no break
      case (byte) 0x1a: //no break
      case (byte) 0x1c: //no break
      case (byte) 0x23: //no break
      case (byte) 0x25: //no break
      case (byte) 0x26: //no break
      case (byte) 0x29: //no break
      case (byte) 0x2a: //no break
      case (byte) 0x2c: //no break
      case (byte) 0x31: //no break
      case (byte) 0x32: //no break
      case (byte) 0x34: //no break
      case (byte) 0x38: //no break
      case (byte) 0x43: //no break
      case (byte) 0x45: //no break
      case (byte) 0x46: //no break
      case (byte) 0x49: //no break
      case (byte) 0x4a: //no break
      case (byte) 0x4c: //no break
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
      case (byte) 0x8b: //no break
      case (byte) 0x8d: //no break
      case (byte) 0x8e: //no break
      case (byte) 0x93: //no break
      case (byte) 0x95: //no break
      case (byte) 0x96: //no break
      case (byte) 0x99: //no break
      case (byte) 0x9a: //no break
      case (byte) 0x9c: //no break
      case (byte) 0xa3: //no break
      case (byte) 0xa5: //no break
      case (byte) 0xa6: //no break
      case (byte) 0xa9: //no break
      case (byte) 0xaa: //no break
      case (byte) 0xac: //no break
      case (byte) 0xb1: //no break
      case (byte) 0xb2: //no break
      case (byte) 0xb4: //no break
      case (byte) 0xb8: //no break
      case (byte) 0xc3: //no break
      case (byte) 0xc5: //no break
      case (byte) 0xc6: //no break
      case (byte) 0xc9: //no break
      case (byte) 0xca: //no break
      case (byte) 0xcc: //no break
      case (byte) 0xd1: //no break
      case (byte) 0xd2: //no break
      case (byte) 0xd4: //no break
      case (byte) 0xd8: //no break
      case (byte) 0xe1: //no break
      case (byte) 0xe2: //no break
      case (byte) 0xe4: //no break
      case (byte) 0xe8: //no break
      case (byte) 0xf0: //no break
      case (byte) 0x0f: //no break
      case (byte) 0x17: //no break
      case (byte) 0x1b: //no break
      case (byte) 0x1d: //no break
      case (byte) 0x1e: //no break
      case (byte) 0x27: //no break
      case (byte) 0x2b: //no break
      case (byte) 0x2d: //no break
      case (byte) 0x2e: //no break
      case (byte) 0x33: //no break
      case (byte) 0x35: //no break
      case (byte) 0x36: //no break
      case (byte) 0x39: //no break
      case (byte) 0x3a: //no break
      case (byte) 0x3c: //no break
      case (byte) 0x47: //no break
      case (byte) 0x4b: //no break
      case (byte) 0x4d: //no break
      case (byte) 0x4e: //no break
      case (byte) 0x53: //no break
      case (byte) 0x55: //no break
      case (byte) 0x56: //no break
      case (byte) 0x59: //no break
      case (byte) 0x5a: //no break
      case (byte) 0x5c: //no break
      case (byte) 0x63: //no break
      case (byte) 0x65: //no break
      case (byte) 0x66: //no break
      case (byte) 0x69: //no break
      case (byte) 0x6a: //no break
      case (byte) 0x6c: //no break
      case (byte) 0x71: //no break
      case (byte) 0x72: //no break
      case (byte) 0x74: //no break
      case (byte) 0x78: //no break
        return 4;
      case (byte) 0x8f: //no break
      case (byte) 0x97: //no break
      case (byte) 0x9b: //no break
      case (byte) 0x9d: //no break
      case (byte) 0x9e: //no break
      case (byte) 0xa7: //no break
      case (byte) 0xab: //no break
      case (byte) 0xad: //no break
      case (byte) 0xae: //no break
      case (byte) 0xb3: //no break
      case (byte) 0xb5: //no break
      case (byte) 0xb6: //no break
      case (byte) 0xb9: //no break
      case (byte) 0xba: //no break
      case (byte) 0xbc: //no break
      case (byte) 0xc7: //no break
      case (byte) 0xcb: //no break
      case (byte) 0xcd: //no break
      case (byte) 0xce: //no break
      case (byte) 0xd3: //no break
      case (byte) 0xd5: //no break
      case (byte) 0xd6: //no break
      case (byte) 0xd9: //no break
      case (byte) 0xda: //no break
      case (byte) 0xdc: //no break
      case (byte) 0xe3: //no break
      case (byte) 0xe5: //no break
      case (byte) 0xe6: //no break
      case (byte) 0xe9: //no break
      case (byte) 0xea: //no break
      case (byte) 0xec: //no break
      case (byte) 0xf1: //no break
      case (byte) 0xf2: //no break
      case (byte) 0xf4: //no break
      case (byte) 0xf8: //no break
      case (byte) 0x1f: //no break
      case (byte) 0x2f: //no break
      case (byte) 0x37: //no break
      case (byte) 0x3b: //no break
      case (byte) 0x3d: //no break
      case (byte) 0x3e: //no break
      case (byte) 0x4f: //no break
      case (byte) 0x57: //no break
      case (byte) 0x5b: //no break
      case (byte) 0x5d: //no break
      case (byte) 0x5e: //no break
      case (byte) 0x67: //no break
      case (byte) 0x6b: //no break
      case (byte) 0x6d: //no break
      case (byte) 0x6e: //no break
      case (byte) 0x73: //no break
      case (byte) 0x75: //no break
      case (byte) 0x76: //no break
      case (byte) 0x79: //no break
      case (byte) 0x7a: //no break
      case (byte) 0x7c: //no break
        return 5;
      case (byte) 0x9f: //no break
      case (byte) 0xaf: //no break
      case (byte) 0xb7: //no break
      case (byte) 0xbb: //no break
      case (byte) 0xbd: //no break
      case (byte) 0xbe: //no break
      case (byte) 0xcf: //no break
      case (byte) 0xd7: //no break
      case (byte) 0xdb: //no break
      case (byte) 0xdd: //no break
      case (byte) 0xde: //no break
      case (byte) 0xe7: //no break
      case (byte) 0xeb: //no break
      case (byte) 0xed: //no break
      case (byte) 0xee: //no break
      case (byte) 0xf3: //no break
      case (byte) 0xf5: //no break
      case (byte) 0xf6: //no break
      case (byte) 0xf9: //no break
      case (byte) 0xfa: //no break
      case (byte) 0xfc: //no break
      case (byte) 0x3f: //no break
      case (byte) 0x5f: //no break
      case (byte) 0x6f: //no break
      case (byte) 0x77: //no break
      case (byte) 0x7b: //no break
      case (byte) 0x7d: //no break
      case (byte) 0x7e: //no break
        return 6;
      case (byte) 0xbf: //no break
      case (byte) 0xdf: //no break
      case (byte) 0xef: //no break
      case (byte) 0xf7: //no break
      case (byte) 0xfb: //no break
      case (byte) 0xfd: //no break
      case (byte) 0xfe: //no break
        return 7;
      //case (byte) 0xFF: //no break
      default:
        return 8;
    }
  }
}
