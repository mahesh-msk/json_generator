/**
 */
package Json;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cluster</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Json.Cluster#getNode5 <em>Node5</em>}</li>
 *   <li>{@link Json.Cluster#getNodeLink <em>Node Link</em>}</li>
 *   <li>{@link Json.Cluster#getName <em>Name</em>}</li>
 *   <li>{@link Json.Cluster#getDescription <em>Description</em>}</li>
 *   <li>{@link Json.Cluster#getPlacement <em>Placement</em>}</li>
 *   <li>{@link Json.Cluster#getNode1 <em>Node1</em>}</li>
 *   <li>{@link Json.Cluster#getNode2 <em>Node2</em>}</li>
 *   <li>{@link Json.Cluster#getNode3 <em>Node3</em>}</li>
 *   <li>{@link Json.Cluster#getNode4 <em>Node4</em>}</li>
 * </ul>
 * </p>
 *
 * @see Json.JsonPackage#getCluster()
 * @model
 * @generated
 */
public interface Cluster extends EObject {
	/**
	 * Returns the value of the '<em><b>Node5</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node5</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node5</em>' containment reference.
	 * @see #setNode5(Node5)
	 * @see Json.JsonPackage#getCluster_Node5()
	 * @model containment="true"
	 * @generated
	 */
	Node5 getNode5();

	/**
	 * Sets the value of the '{@link Json.Cluster#getNode5 <em>Node5</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node5</em>' containment reference.
	 * @see #getNode5()
	 * @generated
	 */
	void setNode5(Node5 value);

	/**
	 * Returns the value of the '<em><b>Node Link</b></em>' containment reference list.
	 * The list contents are of type {@link Json.Link}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Link</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Link</em>' containment reference list.
	 * @see Json.JsonPackage#getCluster_NodeLink()
	 * @model containment="true"
	 * @generated
	 */
	EList<Link> getNodeLink();

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
	 * @see Json.JsonPackage#getCluster_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Json.Cluster#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see Json.JsonPackage#getCluster_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link Json.Cluster#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Placement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placement</em>' containment reference.
	 * @see #setPlacement(Position)
	 * @see Json.JsonPackage#getCluster_Placement()
	 * @model containment="true"
	 * @generated
	 */
	Position getPlacement();

	/**
	 * Sets the value of the '{@link Json.Cluster#getPlacement <em>Placement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement</em>' containment reference.
	 * @see #getPlacement()
	 * @generated
	 */
	void setPlacement(Position value);

	/**
	 * Returns the value of the '<em><b>Node1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node1</em>' containment reference.
	 * @see #setNode1(Node1)
	 * @see Json.JsonPackage#getCluster_Node1()
	 * @model containment="true"
	 * @generated
	 */
	Node1 getNode1();

	/**
	 * Sets the value of the '{@link Json.Cluster#getNode1 <em>Node1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node1</em>' containment reference.
	 * @see #getNode1()
	 * @generated
	 */
	void setNode1(Node1 value);

	/**
	 * Returns the value of the '<em><b>Node2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node2</em>' containment reference.
	 * @see #setNode2(Node2)
	 * @see Json.JsonPackage#getCluster_Node2()
	 * @model containment="true"
	 * @generated
	 */
	Node2 getNode2();

	/**
	 * Sets the value of the '{@link Json.Cluster#getNode2 <em>Node2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node2</em>' containment reference.
	 * @see #getNode2()
	 * @generated
	 */
	void setNode2(Node2 value);

	/**
	 * Returns the value of the '<em><b>Node3</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node3</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node3</em>' containment reference.
	 * @see #setNode3(Node3)
	 * @see Json.JsonPackage#getCluster_Node3()
	 * @model containment="true"
	 * @generated
	 */
	Node3 getNode3();

	/**
	 * Sets the value of the '{@link Json.Cluster#getNode3 <em>Node3</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node3</em>' containment reference.
	 * @see #getNode3()
	 * @generated
	 */
	void setNode3(Node3 value);

	/**
	 * Returns the value of the '<em><b>Node4</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node4</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node4</em>' containment reference.
	 * @see #setNode4(Node4)
	 * @see Json.JsonPackage#getCluster_Node4()
	 * @model containment="true"
	 * @generated
	 */
	Node4 getNode4();

	/**
	 * Sets the value of the '{@link Json.Cluster#getNode4 <em>Node4</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node4</em>' containment reference.
	 * @see #getNode4()
	 * @generated
	 */
	void setNode4(Node4 value);

} // Cluster
