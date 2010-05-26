/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comp429.vrouter;

/**
 * Network Interface Card Objects
 * Any class that implements the NIC interface is capable of acting as
 * a virtual ethernet interface for a virtual software-based TCP/IP
 * router.
 *
 * All instances of NIC objects must produce a seperate thread of execution.
 * This thread of execution must be CPU efficient.
 *
 * @author jeffw
 */
public interface NIC {
  /**
   * Query the MAC address defined for this NIC.
   * Returns a byte array (of length 6 bytes) that contains the
   * MAC address defined for this NIC. <code>byte[0]</code> is the
   * most significant byte of the address.
   * @return a byte array containing the MAC address assigned to this NIC.
   */
  byte [] MACAddress();

  /**
   * Transmit an Ethernet Frame
   * Transmits the ethernet frame to the other "endpoint" connected to
   * this NIC.
   * 
   * @param frame Ethernet Frame to transmit
   * @throws DisconnectedException thrown when the NIC has not connection
   * to another NIC somewhere in the virtual universe.
   */
  void transmit(EthernetFrame frame) throws DisconnectedException;

  /**
   * Receives an Ethernet frame
   * Retrieves an Ethernet frame from the NIC. This function shall not be
   * polled in order to provide timely reception. External classes should
   * rely on the <code>interruptRoutine</code> to be notified when frames
   * are ready.
   * @return An EthernetFrame object as received from the virtual network.
   * @throws FrameUnavailableException if an Ethernet frame is not available.
   */
  EthernetFrame receive() throws FrameUnavailableException;

  /**
   * The virtual CPU in charge of servicing the NIC. This allows the NIC
   * to interrupt the CPU on an as needed basis when it receives a frame.
   * @param cpu the CPU to call an interrupt on.
   * @throws NullPointerException if the CPU passed is null. All NICs must
   * have a valid servicing CPU.
   */
  void CPU(RouterCPU cpu) throws NullPointerException;

  /**
   * Inspect promiscuous mode state
   * 
   * @return true if the NIC is currently in promiscuous mode, false
   * otherwise. NICs that do not support a pomiscuous mode must always
   * return false.
   * 
   */
  boolean promiscuous();

  /**
   * Set promiscuous mode for the NIC
   *
   * A NIC may be in either promiscuous mode or not. Normally, NICs are not
   * in promiscuous mode and will only accept packets that are specifically
   * broadcast to their MAC address or to the Ethernet broadcast address.
   *
   * In promiscuous mode NICs accept all Ethernet frames regardless of
   * destination address and deliver all packets to the operating system
   * for further processing.
   *
   * @param state true sets the NIC to operate in promiscuous mode and
   * process all packets, false sets the NIC in normal mode where only
   * packets matching its address or broadcast will be processed.
   * @return The previous setting of the promiscuous state.
   */
  boolean promiscuous(boolean state);
}
