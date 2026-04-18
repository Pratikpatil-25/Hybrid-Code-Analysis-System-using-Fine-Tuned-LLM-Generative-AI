package org.apache.xml.security.transforms.implementations;

import java.io.OutputStream;

import org.apache.xml.security.signature.NodeFilter;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class TransformEnvelopedSignature extends TransformSpi {

    
    public static final String implementedTransformURI =
        Transforms.TRANSFORM_ENVELOPED_SIGNATURE;

    
    protected String engineGetURI() {
        return implementedTransformURI;
    }

    
    protected XMLSignatureInput enginePerformTransform(
        XMLSignatureInput input, OutputStream os, Transform transformObject
    ) throws TransformationException {
        

        Node signatureElement = transformObject.getElement();

        signatureElement = searchSignatureElement(signatureElement);        
        input.setExcludeNode(signatureElement);   
        input.addNodeFilter(new EnvelopedNodeFilter(signatureElement));
        return input;
    }

    
    private static Node searchSignatureElement(Node signatureElement) 
        throws TransformationException {
        boolean found = false;

        while (true) {
            if (signatureElement == null
                || signatureElement.getNodeType() == Node.DOCUMENT_NODE) {
                break;
            }
            Element el = (Element) signatureElement;
            if (el.getNamespaceURI().equals(Constants.SignatureSpecNS)
                && el.getLocalName().equals(Constants._TAG_SIGNATURE)) {
                found = true;
                break;
            }

            signatureElement = signatureElement.getParentNode();
        }

        if (!found) {
            throw new TransformationException(
                "transform.envelopedSignatureTransformNotInSignatureElement");
        }
        return signatureElement;
    }

    static class EnvelopedNodeFilter implements NodeFilter {
        
        Node exclude;
        
        EnvelopedNodeFilter(Node n) {
            exclude = n;
        }
        
        public int isNodeIncludeDO(Node n, int level) {
            if (n == exclude) {
                return -1;
            }
            return 1;
        }
        
        
        public int isNodeInclude(Node n) {
            if (n == exclude || XMLUtils.isDescendantOrSelf(exclude, n)) { 
                return -1;
            }
            return 1;
                    }
    }
}