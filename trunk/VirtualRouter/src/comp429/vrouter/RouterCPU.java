/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comp429.vrouter;

/**
 * RouterCPU interface to represent a router "CPU"
 * The interface exists to abstract objects that behave like a router CPU
 * and should expected to be interrupted by hardware peripherals.
 * @author jeffw
 */
interface RouterCPU {

  /**
   * interrupt request function
   * Call the <code>interrupt()</code> to inform the "CPU" that there is
   * work to be done on the calling peripheral.
   * @param peripheral The NIC responsible for causing the interrupt and in
   * need of service.
   */
  void interrupt(NIC peripheral);
}
