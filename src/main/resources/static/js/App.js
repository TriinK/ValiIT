import '../css/App.css';
import logo from '../images/logo.svg';
class App extends React.Component {
    constructor(props) {
        super(props);

        this.onOpenModal1 = this.onOpenModal1.bind(this);
        this.onOpenModal2 = this.onOpenModal2.bind(this);
        this.onCloseModal1 = this.onCloseModal1.bind(this);
        this.onCloseModal2 = this.onCloseModal2.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

        this.state = {
            openFirstModal: false,
            openSecondModal: false,
            data:null,
            username: '',
            password: '',
            firstname: '',
            surname: '',
            email: '',
            submitted: false
        };
    }

    onOpenModal1() {
        this.setState({ openFirstModal: true });
    };
    onOpenModal2(){
        this.setState({ openSecondModal: true });
    };
    onCloseModal1(){
        this.setState({ openFirstModal: false });
    };
    onCloseModal2(){
        this.setState({ openSecondModal: false });
    };
    handleChange(e) {
        const { name, value } = e.target;
        this.setState({ [name]: value });
    }

    handleSubmit(e) {
        e.preventDefault();

        this.setState({submitted: true});
    }

  render() {
      const {openFirstModal, openSecondModal} = this.state;
      const { loggingIn } = this.props;
      const { username, password, submitted } = this.state;
      const {firstname, surname, email} = this.state;

    return (
      <div className="App">
          <div className="limiter">
              <div className="wrap-login100">
                  <img src={logo} className="App-logo" alt="logo" />
                  <h1 className="App-title">Kohtumised käeulatuses!</h1>
              <div className="container-login100">
                  <Form onSubmit={this.handleSubmit}>
                      <FormGroup row>
                          <Col sm={11}>
                            <Input type="text" name="username" id="username" placeholder="   Kasutajanimi" value={username} onChange={this.handleChange}/>
                              {submitted && !username &&
                              <div className="help-block">Username is required!</div>
                              }
                          </Col>
                      </FormGroup>
                      <FormGroup row>
                          <Col sm={11}>
                          <Input type="password" name="password" id="password" placeholder="   Parool" value={password} onChange={this.handleChange}/>
                              {submitted && !password &&
                              <div className="help-block">Password is required!</div>
                              }
                          </Col>
                      </FormGroup>
                      <Button className="login-btn">LOGI SISSE</Button>
                      <Button className="new-user-button" onClick={this.onOpenModal1}>LOO KASUTAJA</Button>
                      <Modal open={openFirstModal} onClose={this.onCloseModal1} centered classNames={{ overlay: 'custom-overlay', modal: 'custom-modal'}}>
                          <h4>Uue kasutaja loomine</h4>
                          <Form>
                              <FormGroup>
                                  <Input type="text" name="firstname" id="firstname" placeholder="Eesnimi" value={firstname} onChange={this.handleChange}/>
                              </FormGroup>
                              <FormGroup>
                                  <Input type="text" name="surname" id="surname" placeholder="Perekonnanimi" value={surname} onChange={this.handleChange}/>
                              </FormGroup>
                              <FormGroup>
                                  <Input type="text" name="email" id="email" placeholder="Email" value={email} onChange={this.handleChange}/>
                              </FormGroup>
                              <FormGroup>
                                  <Input type="password" name="password" id="password-modal" placeholder="Parool" value={password} onChange={this.handleChange}/>
                              </FormGroup>
                          </Form>
                          <Button color="warning">LOO</Button>{' '}
                          <Button color="secondary" onClick={this.onCloseModal1}>TÜHISTA</Button>{' '}
                      </Modal>
                          <div className="text-right p-t-13 p-b-23">
                              <p className="txt1">Unustasid <a href='#' className="txt2" onClick={this.onOpenModal2}>kasutajanime/parooli?</a></p>
                              <Modal open={openSecondModal} onClose={this.onCloseModal2} centered classNames={{ overlay: 'custom-overlay', modal: 'custom-modal' }}>
                                  <h4>Parooli taastamine</h4>
                                  <Form>
                                      <FormGroup>
                                          <Input type="text" name="forgot-email" id="forgot-email" placeholder="Sisesta email" />
                                      </FormGroup>
                                  </Form>
                                  <Button color="warning">SAADA</Button>{' '}
                                  <Button color="secondary" onClick={this.onCloseModal2}>TÜHISTA</Button>{' '}
                              </Modal>
                          </div>
                  </Form>
                  </div>
              </div>
          </div>
      </div>
    );
  }
}
//const domContainer = document.querySelector('#App');
ReactDOM.render(<App/>, document.getElementById('App'));