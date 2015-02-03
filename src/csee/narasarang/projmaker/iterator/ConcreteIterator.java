package csee.narasarang.projmaker.iterator;

import csee.narasarang.projmaker.project.ProjectVO;

public class ConcreteIterator implements ItemIterator {
	/**
	 * @uml.property  name="index"
	 */
	private int index;
	/**
	 * @uml.property  name="projectList"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ProjectCollection projectList;

	public ConcreteIterator(ProjectCollection projectList) {
		this.projectList = projectList;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		if(index < projectList.getLength()){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Object next() {
		ProjectVO project = projectList.getProjectAt(index);
		index++;
		return project;
	}

}
