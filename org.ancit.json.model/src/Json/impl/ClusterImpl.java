/**
 */
package Json.impl;

import Json.Cluster;
import Json.JsonPackage;
import Json.Link;
import Json.Node1;
import Json.Node2;
import Json.Node3;
import Json.Node4;
import Json.Node5;
import Json.Position;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cluster</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Json.impl.ClusterImpl#getNode5 <em>Node5</em>}</li>
 *   <li>{@link Json.impl.ClusterImpl#getNodeLink <em>Node Link</em>}</li>
 *   <li>{@link Json.impl.ClusterImpl#getName <em>Name</em>}</li>
 *   <li>{@link Json.impl.ClusterImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link Json.impl.ClusterImpl#getPlacement <em>Placement</em>}</li>
 *   <li>{@link Json.impl.ClusterImpl#getNode1 <em>Node1</em>}</li>
 *   <li>{@link Json.impl.ClusterImpl#getNode2 <em>Node2</em>}</li>
 *   <li>{@link Json.impl.ClusterImpl#getNode3 <em>Node3</em>}</li>
 *   <li>{@link Json.impl.ClusterImpl#getNode4 <em>Node4</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClusterImpl extends MinimalEObjectImpl.Container implements Cluster {
	/**
	 * The cached value of the '{@link #getNode5() <em>Node5</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode5()
	 * @generated
	 * @ordered
	 */
	protected Node5 node5;

	/**
	 * The cached value of the '{@link #getNodeLink() <em>Node Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeLink()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> nodeLink;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPlacement() <em>Placement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlacement()
	 * @generated
	 * @ordered
	 */
	protected Position placement;

	/**
	 * The cached value of the '{@link #getNode1() <em>Node1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode1()
	 * @generated
	 * @ordered
	 */
	protected Node1 node1;

	/**
	 * The cached value of the '{@link #getNode2() <em>Node2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode2()
	 * @generated
	 * @ordered
	 */
	protected Node2 node2;

	/**
	 * The cached value of the '{@link #getNode3() <em>Node3</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode3()
	 * @generated
	 * @ordered
	 */
	protected Node3 node3;

	/**
	 * The cached value of the '{@link #getNode4() <em>Node4</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode4()
	 * @generated
	 * @ordered
	 */
	protected Node4 node4;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClusterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JsonPackage.Literals.CLUSTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node5 getNode5() {
		return node5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode5(Node5 newNode5, NotificationChain msgs) {
		Node5 oldNode5 = node5;
		node5 = newNode5;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JsonPackage.CLUSTER__NODE5, oldNode5, newNode5);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode5(Node5 newNode5) {
		if (newNode5 != node5) {
			NotificationChain msgs = null;
			if (node5 != null)
				msgs = ((InternalEObject)node5).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JsonPackage.CLUSTER__NODE5, null, msgs);
			if (newNode5 != null)
				msgs = ((InternalEObject)newNode5).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JsonPackage.CLUSTER__NODE5, null, msgs);
			msgs = basicSetNode5(newNode5, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsonPackage.CLUSTER__NODE5, newNode5, newNode5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getNodeLink() {
		if (nodeLink == null) {
			nodeLink = new EObjectContainmentEList<Link>(Link.class, this, JsonPackage.CLUSTER__NODE_LINK);
		}
		return nodeLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsonPackage.CLUSTER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsonPackage.CLUSTER__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Position getPlacement() {
		return placement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlacement(Position newPlacement, NotificationChain msgs) {
		Position oldPlacement = placement;
		placement = newPlacement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JsonPackage.CLUSTER__PLACEMENT, oldPlacement, newPlacement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlacement(Position newPlacement) {
		if (newPlacement != placement) {
			NotificationChain msgs = null;
			if (placement != null)
				msgs = ((InternalEObject)placement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JsonPackage.CLUSTER__PLACEMENT, null, msgs);
			if (newPlacement != null)
				msgs = ((InternalEObject)newPlacement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JsonPackage.CLUSTER__PLACEMENT, null, msgs);
			msgs = basicSetPlacement(newPlacement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsonPackage.CLUSTER__PLACEMENT, newPlacement, newPlacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node1 getNode1() {
		return node1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode1(Node1 newNode1, NotificationChain msgs) {
		Node1 oldNode1 = node1;
		node1 = newNode1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JsonPackage.CLUSTER__NODE1, oldNode1, newNode1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode1(Node1 newNode1) {
		if (newNode1 != node1) {
			NotificationChain msgs = null;
			if (node1 != null)
				msgs = ((InternalEObject)node1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JsonPackage.CLUSTER__NODE1, null, msgs);
			if (newNode1 != null)
				msgs = ((InternalEObject)newNode1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JsonPackage.CLUSTER__NODE1, null, msgs);
			msgs = basicSetNode1(newNode1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsonPackage.CLUSTER__NODE1, newNode1, newNode1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node2 getNode2() {
		return node2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode2(Node2 newNode2, NotificationChain msgs) {
		Node2 oldNode2 = node2;
		node2 = newNode2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JsonPackage.CLUSTER__NODE2, oldNode2, newNode2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode2(Node2 newNode2) {
		if (newNode2 != node2) {
			NotificationChain msgs = null;
			if (node2 != null)
				msgs = ((InternalEObject)node2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JsonPackage.CLUSTER__NODE2, null, msgs);
			if (newNode2 != null)
				msgs = ((InternalEObject)newNode2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JsonPackage.CLUSTER__NODE2, null, msgs);
			msgs = basicSetNode2(newNode2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsonPackage.CLUSTER__NODE2, newNode2, newNode2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node3 getNode3() {
		return node3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode3(Node3 newNode3, NotificationChain msgs) {
		Node3 oldNode3 = node3;
		node3 = newNode3;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JsonPackage.CLUSTER__NODE3, oldNode3, newNode3);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode3(Node3 newNode3) {
		if (newNode3 != node3) {
			NotificationChain msgs = null;
			if (node3 != null)
				msgs = ((InternalEObject)node3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JsonPackage.CLUSTER__NODE3, null, msgs);
			if (newNode3 != null)
				msgs = ((InternalEObject)newNode3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JsonPackage.CLUSTER__NODE3, null, msgs);
			msgs = basicSetNode3(newNode3, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsonPackage.CLUSTER__NODE3, newNode3, newNode3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node4 getNode4() {
		return node4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode4(Node4 newNode4, NotificationChain msgs) {
		Node4 oldNode4 = node4;
		node4 = newNode4;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JsonPackage.CLUSTER__NODE4, oldNode4, newNode4);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode4(Node4 newNode4) {
		if (newNode4 != node4) {
			NotificationChain msgs = null;
			if (node4 != null)
				msgs = ((InternalEObject)node4).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JsonPackage.CLUSTER__NODE4, null, msgs);
			if (newNode4 != null)
				msgs = ((InternalEObject)newNode4).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JsonPackage.CLUSTER__NODE4, null, msgs);
			msgs = basicSetNode4(newNode4, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsonPackage.CLUSTER__NODE4, newNode4, newNode4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JsonPackage.CLUSTER__NODE5:
				return basicSetNode5(null, msgs);
			case JsonPackage.CLUSTER__NODE_LINK:
				return ((InternalEList<?>)getNodeLink()).basicRemove(otherEnd, msgs);
			case JsonPackage.CLUSTER__PLACEMENT:
				return basicSetPlacement(null, msgs);
			case JsonPackage.CLUSTER__NODE1:
				return basicSetNode1(null, msgs);
			case JsonPackage.CLUSTER__NODE2:
				return basicSetNode2(null, msgs);
			case JsonPackage.CLUSTER__NODE3:
				return basicSetNode3(null, msgs);
			case JsonPackage.CLUSTER__NODE4:
				return basicSetNode4(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JsonPackage.CLUSTER__NODE5:
				return getNode5();
			case JsonPackage.CLUSTER__NODE_LINK:
				return getNodeLink();
			case JsonPackage.CLUSTER__NAME:
				return getName();
			case JsonPackage.CLUSTER__DESCRIPTION:
				return getDescription();
			case JsonPackage.CLUSTER__PLACEMENT:
				return getPlacement();
			case JsonPackage.CLUSTER__NODE1:
				return getNode1();
			case JsonPackage.CLUSTER__NODE2:
				return getNode2();
			case JsonPackage.CLUSTER__NODE3:
				return getNode3();
			case JsonPackage.CLUSTER__NODE4:
				return getNode4();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JsonPackage.CLUSTER__NODE5:
				setNode5((Node5)newValue);
				return;
			case JsonPackage.CLUSTER__NODE_LINK:
				getNodeLink().clear();
				getNodeLink().addAll((Collection<? extends Link>)newValue);
				return;
			case JsonPackage.CLUSTER__NAME:
				setName((String)newValue);
				return;
			case JsonPackage.CLUSTER__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case JsonPackage.CLUSTER__PLACEMENT:
				setPlacement((Position)newValue);
				return;
			case JsonPackage.CLUSTER__NODE1:
				setNode1((Node1)newValue);
				return;
			case JsonPackage.CLUSTER__NODE2:
				setNode2((Node2)newValue);
				return;
			case JsonPackage.CLUSTER__NODE3:
				setNode3((Node3)newValue);
				return;
			case JsonPackage.CLUSTER__NODE4:
				setNode4((Node4)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case JsonPackage.CLUSTER__NODE5:
				setNode5((Node5)null);
				return;
			case JsonPackage.CLUSTER__NODE_LINK:
				getNodeLink().clear();
				return;
			case JsonPackage.CLUSTER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JsonPackage.CLUSTER__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case JsonPackage.CLUSTER__PLACEMENT:
				setPlacement((Position)null);
				return;
			case JsonPackage.CLUSTER__NODE1:
				setNode1((Node1)null);
				return;
			case JsonPackage.CLUSTER__NODE2:
				setNode2((Node2)null);
				return;
			case JsonPackage.CLUSTER__NODE3:
				setNode3((Node3)null);
				return;
			case JsonPackage.CLUSTER__NODE4:
				setNode4((Node4)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JsonPackage.CLUSTER__NODE5:
				return node5 != null;
			case JsonPackage.CLUSTER__NODE_LINK:
				return nodeLink != null && !nodeLink.isEmpty();
			case JsonPackage.CLUSTER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JsonPackage.CLUSTER__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case JsonPackage.CLUSTER__PLACEMENT:
				return placement != null;
			case JsonPackage.CLUSTER__NODE1:
				return node1 != null;
			case JsonPackage.CLUSTER__NODE2:
				return node2 != null;
			case JsonPackage.CLUSTER__NODE3:
				return node3 != null;
			case JsonPackage.CLUSTER__NODE4:
				return node4 != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ClusterImpl
