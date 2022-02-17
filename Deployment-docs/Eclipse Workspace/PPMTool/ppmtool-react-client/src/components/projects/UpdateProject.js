import React, { Component } from 'react'
import { connect } from 'react-redux';
import PropTypes from "prop-types"
import { getProject, createProject } from '../../actions/projectActions.js'
import classnames from 'classnames';

class UpdateProject extends Component {

    constructor(){
        super();
        
        this.state = {
            projectName: "",
            projectIdentifier: "",
            description: "",
            // startDate: "",
            // endDate: ""
            
        };

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    };

    static getDerivedStateFromProps(nextProps, prevState){
            if(nextProps !== prevState){
               
               const { projectName,
                projectIdentifier,
                description,
                startDate,
                endDate} = nextProps.project;
               
                return { projectName,
                    projectIdentifier,
                    description,
                    startDate,
                    endDate};
            }

            return null;
    }

    onChange(e){
        this.setState({[e.target.name]: e.target.value});
    }

    onSubmit(e){
        e.preventDefault();

        const newProject = {
            projectName: this.state.projectName,
            projectIdentifier: this.state.projectIdentifier,
            description: this.state.description,
            startDate: this.state.startDate,
            endDate: this.state.endDate
        }
        
        this.props.createProject(newProject, this.props.history, true)
        
    }

    componentDidMount(){
        const id = this.props.match.params.id;
        this.props.getProject(id);
    }

    render() {
        return (
            <div className="project">
                <div className="container">
                    <div className="row">
                        <div className="col-md-8 m-auto">
                            <h5 className="display-4 text-center">Create / Edit Project form</h5>
                            <hr />
                            <form onSubmit={this.onSubmit}>
                                <div className="form-group">
                                    <input type="text" className={classnames("form-control form-control-lg ")} placeholder="Project Name"
                                    name="projectName" value={this.state.projectName} onChange={this.onChange}/>
                                   
                                </div>
                                <div className="form-group">
                                    <input type="text"  className={classnames("form-control form-control-lg")} placeholder="Unique Project ID"
                                    name="projectIdentifier" value={this.state.projectIdentifier} onChange={this.onChange} />
                                   
                                </div>
                                <div className="form-group">
                                    <textarea  className={classnames("form-control form-control-lg")} placeholder="Project Description"
                                    name="description"  value={this.state.description} onChange={this.onChange}></textarea>
                                    
                                </div>
                                <h6>Start Date</h6>
                                <div className="form-group">
                                    <input type="date" className="form-control form-control-lg" name="startDate" 
                                     value={this.state.startDate} onChange={this.onChange}/>
                                </div>
                                <h6>Estimated End Date</h6>
                                <div className="form-group">
                                    <input type="date" className="form-control form-control-lg" name="endDate"  
                                    value={this.state.endDate} onChange={this.onChange}/>
                                </div>
        
                                <input type="submit" className="btn btn-primary btn-block mt-4" />
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

UpdateProject.propTypes = {
    project: PropTypes.object.isRequired,
    getProject: PropTypes.func.isRequired,
    createProject: PropTypes.func.isRequired
}

const mapStateToProps = state => ({
    project: state.project.project
})

export default connect(mapStateToProps, { getProject, createProject })(UpdateProject);
