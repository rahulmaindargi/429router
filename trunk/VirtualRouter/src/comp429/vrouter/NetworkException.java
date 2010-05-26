/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comp429.vrouter;

/**
 * Base class for network communication exceptions
 * The virtual router may encounter a variety of errors. This is the base
 * class from which specific exception types should be derived. It may also
 * be used as an exception under non-specific circumstances.
 * @author jeffw
 */
public class NetworkException extends java.lang.Exception {
  /**
   * General NetworkException Object with given reason
   * Used to indicate any network exception and provide information
   * related to the cause of the problem.
   * @param reason A description of the problem
   */
  NetworkException(String reason) {
    super(reason);
  }

  /**
   * General, unexplained Network Object
   * Used to indicate any network exception without explanation
   */
  NetworkException() {
    super();
  }
};