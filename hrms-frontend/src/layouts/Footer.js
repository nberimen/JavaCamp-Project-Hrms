import React from "react";



export default function Footer() {
    return (
        <footer className="text-center text-lg-start bg-light text-muted">
          <section
            className="d-flex justify-content-center justify-content-lg-between p-4 border-bottom"
          >
           
            <div className="me-5 d-none d-lg-block">
              <span>Get connected with us on social networks:</span>
            </div>
           
            <div>
              <a href="" className="me-4 text-reset">
              </a>
              <a href="" className="me-4 text-reset">
                
              </a>
              <a href="" className="me-4 text-reset">
               
              </a>
              <a href="" className="me-4 text-reset">
                
              </a>
              <a href="" className="me-4 text-reset">
                
              </a>
              <a href="" className="me-4 text-reset">
                
              </a>
            </div>
          </section>
        
          <section className="">
            <div className="container text-center text-md-start mt-5">
              <div className="row mt-3">
                <div className="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                  <h6 className="text-uppercase fw-bold mb-4">
                    Company name
                  </h6>
                  <p>
                    Here you can use rows and columns to organize your footer content. Lorem ipsum
                    dolor sit amet, consectetur adipisicing elit.
                  </p>
                </div>
                <div className="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                  <h6 className="text-uppercase fw-bold mb-4">
                    Products
                  </h6>
                  <p>
                    <a href="#!" className="text-reset">Angular</a>
                  </p>
                  <p>
                    <a href="#!" className="text-reset">React</a>
                  </p>
                  <p>
                    <a href="#!" className="text-reset">Vue</a>
                  </p>
                  <p>
                    <a href="#!" className="text-reset">Laravel</a>
                  </p>
                </div>
        
                <div className="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                  <h6 className="text-uppercase fw-bold mb-4">
                    Useful links
                  </h6>
                  <p>
                    <a href="#!" className="text-reset">Pricing</a>
                  </p>
                  <p>
                    <a href="#!" className="text-reset">Settings</a>
                  </p>
                  <p>
                    <a href="#!" className="text-reset">Orders</a>
                  </p>
                  <p>
                    <a href="#!" className="text-reset">Help</a>
                  </p>
                </div>
        
                <div className="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                  <h6 className="text-uppercase fw-bold mb-4">
                    Contact
                  </h6>
                  <p> New York, NY 10012, US</p>
                  <p>
                    info@example.com
                  </p>
                  <p> + 01 234 567 89</p>
                  <p> + 01 234 567 89</p>
                </div>
              </div>
            </div>
          </section>
          <div className="text-center p-4" style={{background: "rgba(0, 0, 0, 0.05)"}}>
            © 2021:
            <a className="text-reset fw-bold" href="http://localhost:3000/home">hrms.com</a>
          </div>
        </footer>
    );
}