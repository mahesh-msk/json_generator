/**
 */
package Json;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Json.JsonModel#getCluster <em>Cluster</em>}</li>
 *   <li>{@link Json.JsonModel#getName <em>Name</em>}</li>
 *   <li>{@link Json.JsonModel#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see Json.JsonPackage#getJsonModel()
 * @model
 * @generated
 */
public interface JsonModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Cluster</b></em>' containment reference list.
	 * The list contents are of type {@link Json.Cluster}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster</em>' containment reference list.
	 * @see Json.JsonPackage#getJsonModel_Cluster()
	 * @model containment="true"
	 * @generated
	 */
	EList<Cluster> getCluster();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Json.JsonPackage#getJsonModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Json.JsonModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link Json.Link}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see Json.JsonPackage#getJsonModel_Links()
	 * @model containment="true"
	 * @generated
	 */
	EList<Link> getLinks();

} // JsonModel
