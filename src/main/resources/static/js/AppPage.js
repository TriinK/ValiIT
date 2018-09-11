import React from 'react'
import {Component} from 'react'
import '../css/AppPage.css';
import {Button, Form, FormGroup, Label, Input, FormText} from 'reactstrap';
import Modal from 'react-responsive-modal';


class AppPage extends Component {
    state = {
        open: false,
    };

    onOpenModal = () => {
        this.setState({open: true});
    };

    onCloseModal = () => {
        this.setState({open: false});
    };

    componentDidMount() {
        client({method: 'GET', path: '/api/appointments'}).done(response => {
            this.setState({employees: response.entity._embedded.employees});
        });
    }
    }

    render() {
        const {appointments, isLoading} = this.state;
        const {open} = this.state;
        if (isLoading) {
            return <p>Loading...</p>;
        }
        return (
            <div className="AppPage">
                <body>
                <div className="Wrap">
                    <header>
                        <nav>
                            <button type="button" id="logout" className="btn btn-secondary" onClick={this.onOpenModal}>
                                LOGI VÄLJA
                            </button>

                            <Modal
                                open={open}
                                onClose={this.onCloseModal}
                                center
                                classNames={{
                                    transitionEnter: 'transition-enter',
                                    transitionEnterActive: 'transition-enter-active',
                                    transitionExit: 'transition-exit-active',
                                    transitionExitActive: 'transition-exit-active',
                                }}
                                animationDuration={1000}
                            >
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam
                                    pulvinar risus non risus hendrerit venenatis. Pellentesque sit amet
                                    hendrerit risus, sed porttitor quam.
                                </p>
                            </Modal>
                        </nav>
                    </header>

                    <div className="Greeting">
                        <h1> Hello - Triin</h1>
                    </div>
                    <div className="wrapper">
                        <div className="container3">
                            <table>
                                <thead>
                                <tr>
                                    <th>Nimi</th>
                                    <th>Aeg</th>
                                    <th>Kirjeldus</th>
                                    <th>Tehtud</th>
                                    <th>Valikud</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>Arsti aeg</td>
                                    <td>30. oktoober 2018</td>
                                    <td>Silmaarsti aeg. Silmaarsti nimi on: dr Kukk</td>
                                    <td><Input type="checkbox" id="checkbox2"/>{' '}</td>
                                    <div className="buttons">
                                        <button type="button" id="change" className="btn btn-secondary"
                                                onClick={this.onOpenModal}>
                                            MUUDA
                                        </button>
                                        <Modal
                                            open={open}
                                            onClose={this.onCloseModal}
                                            center
                                            classNames={{
                                                transitionEnter: 'transition-enter',
                                                transitionEnterActive: 'transition-enter-active',
                                                transitionExit: 'transition-exit-active',
                                                transitionExitActive: 'transition-exit-active',
                                            }}
                                            animationDuration={1000}>
                                            <p>
                                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam
                                                pulvinar risus non risus hendrerit venenatis. Pellentesque sit amet
                                                hendrerit risus, sed porttitor quam.
                                            </p>
                                        </Modal>
                                        <button type="button" id="change" className="btn btn-secondary"
                                                onClick={this.onOpenModal}>
                                            KUSTUTA
                                        </button>
                                        <Modal
                                            open={open}
                                            onClose={this.onCloseModal}
                                            center
                                            classNames={{
                                                transitionEnter: 'transition-enter',
                                                transitionEnterActive: 'transition-enter-active',
                                                transitionExit: 'transition-exit-active',
                                                transitionExitActive: 'transition-exit-active',
                                            }}
                                            animationDuration={1000}
                                        >
                                            <p>
                                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam
                                                pulvinar risus non risus hendrerit venenatis. Pellentesque sit amet
                                                hendrerit risus, sed porttitor quam.
                                            </p>
                                        </Modal>
                                    </div>

                                </tr>

                                <tr>
                                    <td>Sõbraga kokkusaamine</td>
                                    <td>11. september kella 12 aeg</td>
                                    <td>Saan sõbraga kokku kohvikus hommikul</td>
                                    <td><Input type="checkbox" id="checkbox2"/>{' '}</td>
                                    <div className="buttons">
                                        <button type="button" id="change" className="btn btn-secondary"
                                                onClick="prepareCustomerAdd()">MUUDA
                                        </button>
                                        <button type="button" id="delete" className="btn btn-secondary"
                                                onClick="prepareCustomerAdd()">KUSTUTA
                                        </button>
                                    </div>
                                </tr>
                                </tbody>

                            </table>


                        </div>
                    </div>


                </div>

                </body>

            </div>
        );
    }
}

export default AppPage;