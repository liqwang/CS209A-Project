
package edu.sustech.search.engine.github.API.rate;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "core",
    "graphql",
    "search",
    "source_import",
    "integration_manifest",
    "code_scanning_upload",
    "actions_runner_registration",
    "scim"
})
@Generated("jsonschema2pojo")
public class Resources {

    /**
     * Rate Limit
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("core")
    private edu.sustech.search.engine.github.API.rate.Core core;
    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("graphql")
    private edu.sustech.search.engine.github.API.rate.Graphql graphql;
    /**
     * Rate Limit
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("search")
    private edu.sustech.search.engine.github.API.rate.Search search;
    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("source_import")
    private SourceImport sourceImport;
    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("integration_manifest")
    private IntegrationManifest integrationManifest;
    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("code_scanning_upload")
    private CodeScanningUpload codeScanningUpload;
    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("actions_runner_registration")
    private ActionsRunnerRegistration actionsRunnerRegistration;
    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("scim")
    private edu.sustech.search.engine.github.API.rate.Scim scim;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * Rate Limit
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("core")
    public edu.sustech.search.engine.github.API.rate.Core getCore() {
        return core;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("core")
    public void setCore(Core core) {
        this.core = core;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("graphql")
    public edu.sustech.search.engine.github.API.rate.Graphql getGraphql() {
        return graphql;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("graphql")
    public void setGraphql(Graphql graphql) {
        this.graphql = graphql;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("search")
    public edu.sustech.search.engine.github.API.rate.Search getSearch() {
        return search;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("search")
    public void setSearch(Search search) {
        this.search = search;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("source_import")
    public SourceImport getSourceImport() {
        return sourceImport;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("source_import")
    public void setSourceImport(SourceImport sourceImport) {
        this.sourceImport = sourceImport;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("integration_manifest")
    public IntegrationManifest getIntegrationManifest() {
        return integrationManifest;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("integration_manifest")
    public void setIntegrationManifest(IntegrationManifest integrationManifest) {
        this.integrationManifest = integrationManifest;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("code_scanning_upload")
    public CodeScanningUpload getCodeScanningUpload() {
        return codeScanningUpload;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("code_scanning_upload")
    public void setCodeScanningUpload(CodeScanningUpload codeScanningUpload) {
        this.codeScanningUpload = codeScanningUpload;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("actions_runner_registration")
    public ActionsRunnerRegistration getActionsRunnerRegistration() {
        return actionsRunnerRegistration;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("actions_runner_registration")
    public void setActionsRunnerRegistration(ActionsRunnerRegistration actionsRunnerRegistration) {
        this.actionsRunnerRegistration = actionsRunnerRegistration;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("scim")
    public edu.sustech.search.engine.github.API.rate.Scim getScim() {
        return scim;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * 
     */
    @JsonProperty("scim")
    public void setScim(Scim scim) {
        this.scim = scim;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Resources.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("core");
        sb.append('=');
        sb.append(((this.core == null)?"<null>":this.core));
        sb.append(',');
        sb.append("graphql");
        sb.append('=');
        sb.append(((this.graphql == null)?"<null>":this.graphql));
        sb.append(',');
        sb.append("search");
        sb.append('=');
        sb.append(((this.search == null)?"<null>":this.search));
        sb.append(',');
        sb.append("sourceImport");
        sb.append('=');
        sb.append(((this.sourceImport == null)?"<null>":this.sourceImport));
        sb.append(',');
        sb.append("integrationManifest");
        sb.append('=');
        sb.append(((this.integrationManifest == null)?"<null>":this.integrationManifest));
        sb.append(',');
        sb.append("codeScanningUpload");
        sb.append('=');
        sb.append(((this.codeScanningUpload == null)?"<null>":this.codeScanningUpload));
        sb.append(',');
        sb.append("actionsRunnerRegistration");
        sb.append('=');
        sb.append(((this.actionsRunnerRegistration == null)?"<null>":this.actionsRunnerRegistration));
        sb.append(',');
        sb.append("scim");
        sb.append('=');
        sb.append(((this.scim == null)?"<null>":this.scim));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.core == null)? 0 :this.core.hashCode()));
        result = ((result* 31)+((this.sourceImport == null)? 0 :this.sourceImport.hashCode()));
        result = ((result* 31)+((this.scim == null)? 0 :this.scim.hashCode()));
        result = ((result* 31)+((this.search == null)? 0 :this.search.hashCode()));
        result = ((result* 31)+((this.integrationManifest == null)? 0 :this.integrationManifest.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.graphql == null)? 0 :this.graphql.hashCode()));
        result = ((result* 31)+((this.actionsRunnerRegistration == null)? 0 :this.actionsRunnerRegistration.hashCode()));
        result = ((result* 31)+((this.codeScanningUpload == null)? 0 :this.codeScanningUpload.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Resources) == false) {
            return false;
        }
        Resources rhs = ((Resources) other);
        return ((((((((((this.core == rhs.core)||((this.core!= null)&&this.core.equals(rhs.core)))&&((this.sourceImport == rhs.sourceImport)||((this.sourceImport!= null)&&this.sourceImport.equals(rhs.sourceImport))))&&((this.scim == rhs.scim)||((this.scim!= null)&&this.scim.equals(rhs.scim))))&&((this.search == rhs.search)||((this.search!= null)&&this.search.equals(rhs.search))))&&((this.integrationManifest == rhs.integrationManifest)||((this.integrationManifest!= null)&&this.integrationManifest.equals(rhs.integrationManifest))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.graphql == rhs.graphql)||((this.graphql!= null)&&this.graphql.equals(rhs.graphql))))&&((this.actionsRunnerRegistration == rhs.actionsRunnerRegistration)||((this.actionsRunnerRegistration!= null)&&this.actionsRunnerRegistration.equals(rhs.actionsRunnerRegistration))))&&((this.codeScanningUpload == rhs.codeScanningUpload)||((this.codeScanningUpload!= null)&&this.codeScanningUpload.equals(rhs.codeScanningUpload))));
    }

}
